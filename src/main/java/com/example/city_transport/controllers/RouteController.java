package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.StopRoute;
import com.example.city_transport.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class RouteController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final RouteService routeService;

    private final StopService stopService;
    private final SetRouteService setRouteService;
    private final StopRouteService stopRouteService;
    private final TransportService transportService;
    private final TraficJemService traficJemService;
    @GetMapping("/routes/{numberRoute}")
    public String routeInfoPage(@PathVariable int numberRoute, Model model) throws SQLException {
        model.addAttribute("route", routeService.getRouteByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.findStopByNumberRoute(numberRoute, httpSessionBean.getConnection()));
        model.addAttribute("transport", transportService.findTransportByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("allTransport", transportService.transportList(httpSessionBean.getConnection()));
        model.addAttribute("freeTransport", transportService.findFreeTransport(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("freeStop", stopService.findFreeByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("traficJemTitle", traficJemService.findByRouteId(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getConnection().getMetaData().getUserName());
        return "route-info";
    }
    @PostMapping("/routes/deleteTraficJem/{numberRoute}/{numberStop}")
    public String deleteTraficJem(@PathVariable int numberRoute, @PathVariable int numberStop){
        traficJemService.deleteByRouteId(numberRoute, numberStop ,httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
    }
    @PostMapping("/routes/addStop/{numberRoute}")
    public String addStopByNumberRoute(@PathVariable int numberRoute, @RequestParam int numberStop,
                                       @RequestParam int stopOrder){
        stopRouteService.addStopRoute(new StopRoute(numberRoute, numberStop, stopOrder),
                httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
    }
    @PostMapping("/routes/{numberRoute}")
    public String createSetRoute(@PathVariable int numberRoute, @RequestParam int idTransport){
        setRouteService.addSetRoute(new SetRoute(numberRoute, idTransport), httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
    }
    @PostMapping("/routes/deleteTransport/{numberRoute}")
    public String deleteTransport(@RequestParam int idTransport){
        setRouteService.deleteSetRoute(idTransport, httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
    }
    //name="${item.numberStop}"
    @PostMapping("/routes/deleteStop/{numberRoute}")
    public String deleteStopRoute(@RequestParam int numberStop, @PathVariable int numberRoute){
        stopRouteService.deleteStopRoute(numberStop, numberRoute, httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
    }

    @PostMapping("route/delete/{numberRoute}")
    public String delete(@PathVariable int numberRoute){
        routeService.deleteRoute(numberRoute, httpSessionBean.getConnection());
        return "redirect:/routes";
    }
    @PostMapping("route/create")
    public String add(Route route, @RequestParam(name = "startPoint") int startPoint,
                      @RequestParam(name = "endPoint") int endPoint,
                      @RequestParam(name = "stopOrder") int stopOrder){
        routeService.addRoute(route, httpSessionBean.getConnection());
        stopRouteService.addStopRoute(new StopRoute(route.getNumberRoute(), startPoint, 1),
                httpSessionBean.getConnection());
        stopRouteService.addStopRoute(new StopRoute(route.getNumberRoute(), endPoint, stopOrder),
                httpSessionBean.getConnection());
        return "redirect:/routes";
    }
}
