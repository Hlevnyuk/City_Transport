package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.Stop;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final RoadRepairService roadRepairService;
    @GetMapping("/routes/{numberRoute}")
    public String routeInfoPage(@PathVariable int numberRoute, Model model) throws SQLException {
        model.addAttribute("route", routeService.getRouteByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.findStopByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("maxStopOrder", stopRouteService.checkStopOrder(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("transport", transportService.findTransportByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("allTransport", transportService.transportList(httpSessionBean.getConnection()));
        model.addAttribute("freeTransport", transportService.findFreeTransport(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("freeStop", stopService.findFreeByNumberRoute(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("traficJemTitle", traficJemService.findByRouteId(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("roadRepairTitle", roadRepairService.findByRouteId(numberRoute,
                httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "route-info";
    }
    @PostMapping("/routes/deleteRoadRepair/{numberRoute}/{numberStop}")
    public String deleteRoadRepairByRouteId(@PathVariable int numberRoute, @PathVariable int numberStop){
        roadRepairService.deleteByNumberRoute(numberRoute, numberStop, httpSessionBean.getConnection());
        return "redirect:/routes/{numberRoute}";
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
    @PostMapping("/route/updateInterval/{numberRoute}")
    public String updateInterval(@PathVariable int numberRoute, @RequestParam String interval, Model model){
        routeService.updateInterval(interval, numberRoute, httpSessionBean.getConnection());
        model.addAttribute("role", httpSessionBean.getRole());
        return "redirect:/routes/{numberRoute}";
    }
    @PostMapping("/routes/deleteStop/{numberRoute}")
    public String deleteStopRoute(@RequestParam int numberStop, @PathVariable int numberRoute){
        //stopRouteService.findByRoute(numberRoute, httpSessionBean.getConnection());
        stopRouteService.deleteStopRoute(numberStop, numberRoute, httpSessionBean.getConnection());
        int count = stopRouteService.findByRoute(numberRoute, httpSessionBean.getConnection()).size();
        if(count == 0){
            return "redirect:/routes";
        }
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
                      @RequestParam(name = "stopOrder") int stopOrder, Model model){
        int id = routeService.addRoute(route, httpSessionBean.getConnection());
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        stopRouteService.addStopRoute(new StopRoute(id, startPoint, 1),
                httpSessionBean.getConnection());
        stopRouteService.addStopRoute(new StopRoute(id, endPoint, stopOrder),
                httpSessionBean.getConnection());
        return "redirect:/routes";
    }
    @PostMapping("/route/filter")
    public String findRoute(@RequestParam int start,
                            @RequestParam int end, RedirectAttributes redirectAttributes){
        //stopService.stopList(httpSessionBean.getConnection());
        //stopService.findByAddress(startPoint, endPoint, httpSessionBean.getConnection())
        redirectAttributes.addAttribute("start", start);
        redirectAttributes.addAttribute("end", end);
        return "redirect:/route-filter/{start}/{end}";
    }
    @GetMapping("/route-filter/{start}/{end}")
    public String findGetRoute(@PathVariable int start,
                            @PathVariable int end, Model model){
        //stopService.stopList(httpSessionBean.getConnection());
        //stopService.findByAddress(startPoint, endPoint, httpSessionBean.getConnection());
        model.addAttribute("routeTitle", routeService.findByAddress(start, end, httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "route-filter";
    }
}
