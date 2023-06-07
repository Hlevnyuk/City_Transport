package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Stop;
import com.example.city_transport.services.StopRouteService;
import com.example.city_transport.services.StopService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class StopController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final StopService stopService;
    private final StopRouteService stopRouteService;
    @PostMapping("/stop/add")
    public String addStop(Stop stop, @RequestParam(name = "numberStop") int numberStop,
                          @RequestParam(name = "address") String address){
        stopService.addStop(stop, httpSessionBean.getConnection());
        return "redirect:/admin-panel";
    }
}
