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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Date;
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
}
