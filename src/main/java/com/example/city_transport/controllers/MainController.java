package com.example.city_transport.controllers;
import com.example.city_transport.Comparator.CustomComparator;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.TraficJem;
import com.example.city_transport.repositories.RouteRepository;
import com.example.city_transport.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final LoginService loginService;
    private final RouteService routeService;
    private final TraficJemService traficJemService;
    private final StopService stopService;
    private final RoadRepairService roadRepairService;
    private final ContractService contractService;
    private final FirmService firmService;
    private final TypeTransportService typeTransportService;
    private final FunctionsService functionsService;
    private final TicketSoldService ticketSoldService;
    private final AnaliticaService analiticaService;
    @Autowired
    private HttpSessionBean httpSessionBean;
    @GetMapping("/")
    public String mainPage(Model model) throws SQLException {
        model.addAttribute("role", httpSessionBean.getRole());
        return "main";
    }
    @GetMapping("/routes")
    public String routePage(Model model) throws SQLException {
//        model.addAttribute("route", routeService.routeList(httpSessionBean.getConnection()));
        model.addAttribute("routeTitle", routeService.routeTitleList(httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "routes";
    }
    @GetMapping("/traficJem")
    public String traficJemPage(Model model) throws SQLException {
        model.addAttribute("traficJemTitle",
                traficJemService.findAllTraficJemTitle(httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "traficJem";
    }
    @GetMapping("/roadRepair")
    public String roadRepairPage(Model model) throws SQLException {
        model.addAttribute("roadRepair", roadRepairService.roadRepairList(httpSessionBean.getConnection()));
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "roadRepair";
    }
    @GetMapping("/contract")
    public String contractPage(Model model) throws SQLException {
        model.addAttribute("contract", contractService.contractList(httpSessionBean.getConnection()));
        model.addAttribute("typeTransport", typeTransportService.transportList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "contract";
    }
    public static <K, V> Map<K, V> sortByValues(Map<K, V> map)
    {
        Comparator<K> comparator = new CustomComparator(map);

        Map<K, V> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);

        return sortedMap;
    }
    @GetMapping("/analyticks/{result}")
    public String analyticksPage(@PathVariable int result, Model model){
        if(Objects.equals(httpSessionBean.getRole(), "transport_employee")) {
            model.addAttribute("ticketSold", ticketSoldService.findAll(httpSessionBean.getConnection()));
            model.addAttribute("routeTitle", routeService.routeTitleList(httpSessionBean.getConnection()));
            model.addAttribute("result", result);
        }
        if(Objects.equals(httpSessionBean.getRole(), "administrator")) {
            Map<Integer, Integer> topFiveMap = new TreeMap<>();
            Map<Integer, Integer> finalTopFiveMap = topFiveMap;
            analiticaService.findAll(httpSessionBean.getConnection()).
                    forEach((x) -> finalTopFiveMap.put(x.getNumberRouteR(), x.getKolTicketSoldR()));
            topFiveMap = sortByValues(finalTopFiveMap);
            model.addAttribute("topFive", topFiveMap);
        }
        model.addAttribute("role", httpSessionBean.getRole());
        return "analyticks";
    }
    @GetMapping("/admin-panel")
    public String adminPanelPage(Model model){
        model.addAttribute("stop", stopService.stopList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "admin-panel";
    }
}
