package com.example.city_transport.controllers;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.TicketSold;
import com.example.city_transport.services.TicketSoldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor
public class TicketSoldController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final TicketSoldService ticketSoldService;
    @PostMapping("/ticketSold/create")
    public String save(TicketSold ticketSold){
        ticketSoldService.save(ticketSold, httpSessionBean.getConnection());
        return "redirect:/analyticksTicketSold/0";
    }
}
