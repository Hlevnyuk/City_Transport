package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransportController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    @Autowired
    private TransportService transportService;
    @GetMapping("/transport")
    public String transportPage(Model model){
        model.addAttribute("transport", transportService.transportList(httpSessionBean.getConnection())
                .stream().filter(el -> el.getNumberTransport() != 0 &&
                        el.getGarage() != null).toList());
        model.addAttribute("transportChange", transportService.transportList(httpSessionBean.getConnection())
                        .stream().filter(el -> el.getNumberTransport() == 0 ||
                        el.getGarage() == null).toList());
        return "transport";
    }
    @PostMapping("/transport/change/{idTransport}")
    public String transportChange(@PathVariable int idTransport, @RequestParam int numberTransport,
                                  @RequestParam String garage){
        transportService.change(idTransport, numberTransport, garage, httpSessionBean.getConnection());
        return "redirect:/transport";
    }
    @PostMapping("/transport/delete/{idTransport}")
    public String transportDelete(@PathVariable int idTransport){
        transportService.deleteTransport(idTransport, httpSessionBean.getConnection());
        return "redirect:/transport";
    }
}
