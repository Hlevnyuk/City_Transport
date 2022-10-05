package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.TicketSold;
import com.example.city_transport.services.TicketSoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;

@Controller
@RequiredArgsConstructor
public class TicketSoldController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final TicketSoldService ticketSoldService;
//    @GetMapping("/analyticks/{result}")
//    public String findAll(@PathVariable int result, Model model){
//        model.addAttribute("ticketSold", ticketSoldService.findAll(httpSessionBean.getConnection()));
//        model.addAttribute("result", result);
//        System.out.println(ticketSoldService.findAll(httpSessionBean.getConnection()));
//        return "analyticks";
//    }
    @PostMapping("/ticketSold/create")
    public String save(TicketSold ticketSold){
        ticketSoldService.save(ticketSold, httpSessionBean.getConnection());
        return "redirect:/analyticks/0";
    }
}
