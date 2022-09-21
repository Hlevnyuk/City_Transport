package com.example.city_transport.controllers;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.TraficJem;
import com.example.city_transport.repositories.RouteRepository;
import com.example.city_transport.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final RouteService routeService;
    private final TraficJemService traficJemService;
    private final StopService stopService;
    @Autowired
    private HttpSessionBean httpSessionBean;
    @GetMapping("/")
    public String mainPage(){
        return "main";
    }
    @GetMapping("/routes")
    public String routePage(Model model) throws SQLException {
        model.addAttribute("route", routeService.routeList(httpSessionBean.getConnection()));
        model.addAttribute("routeTitle", routeService.routeTitleList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getConnection().getMetaData().getUserName());
        return "routes";
    }
    @GetMapping("/traficJem")
    public String traficJemPage(Model model) throws SQLException {
        model.addAttribute("traficJemTitle", traficJemService.traficJemList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getConnection().getMetaData().getUserName());
        return "traficJem";
    }
    @GetMapping("/roadRepair")
    public String roadRepairPage(Model model) throws SQLException {
        model.addAttribute("roadRepairTitle");
        model.addAttribute("role", httpSessionBean.getConnection().getMetaData().getUserName());
        return "roadRepair";
    }
}
