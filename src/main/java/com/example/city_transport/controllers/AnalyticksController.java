package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.services.FunctionsService;
import com.example.city_transport.services.RouteService;
import com.example.city_transport.services.TicketSoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequiredArgsConstructor
public class AnalyticksController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    @Autowired
    private FunctionsService functionsService;
    private final RouteService routeService;
    private final TicketSoldService ticketSoldService;
    @GetMapping("/analyticks/route")
    public String routeStatistics(@RequestParam int id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeStart,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeFinal,
                                 Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("ticketSold", ticketSoldService.findAll(httpSessionBean.getConnection()));
        int result = 0;
        result = functionsService.analizRoute(id, timeStart, timeFinal, httpSessionBean.getConnection());
        redirectAttributes.addAttribute("result", result);
        return "redirect:/analyticksTicketSold/{result}";
    }
//    @PostMapping("/analyticksTicketSold/route")
//    public String routeStatistics2(@RequestParam int id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeStart,
//                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeFinal,
//                                  Model model, RedirectAttributes redirectAttributes){
//
//        int result = 0;
//        result = functionsService.analizRoute(id, timeStart, timeFinal, httpSessionBean.getConnection());
//        redirectAttributes.addAttribute("result", result);
//        return "redirect:/analyticksTicketSold/{result}";
//    }
//    @GetMapping("/statistics/client/")
//    public String clientStatistics(Model model){
//        Map<String, Integer> fClientRankMap = new TreeMap<>();
//        functionsService.callClientRank(httpSessionBean.getConnection()).
//                forEach((x) -> fClientRankMap.put(x.getClientName(), x.getCountVisits()));
//        model.addAttribute("clientRank", fClientRankMap);
//
//        System.out.println("Map: " + fClientRankMap);
//        return "statistics-client";
//    }
//    @GetMapping("/statistics/worker/")
//    public String workerStatistics(Model model){
//        Map<String, Integer> fManagerRankMap4R = new TreeMap<>();
//        Map<String, BigDecimal> fManagerRankMap4P = new TreeMap<>();
//        Map<String, Integer> fTourManagerRankMap = new TreeMap<>();
//
//        functionsService.callManagerRank(httpSessionBean.getConnection()).
//                forEach(x-> fManagerRankMap4R.put(x.getName(), x.getRequests()));
//        functionsService.callManagerRank(httpSessionBean.getConnection()).
//                forEach(x-> fManagerRankMap4P.put(x.getName(), x.getProfit()));
//        functionsService.callTourManagerRank(httpSessionBean.getConnection()).
//                forEach(x-> fTourManagerRankMap.put(x.getName(), x.getCreatedTours()));
//
//        model.addAttribute("managerRankRequests", fManagerRankMap4R);
//        model.addAttribute("managerRankProfit", fManagerRankMap4P);
//        model.addAttribute("tourManagerRank", fTourManagerRankMap);
//        return "statistics-worker";
//    }
}
