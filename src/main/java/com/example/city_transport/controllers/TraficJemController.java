package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.TraficJem;
import com.example.city_transport.services.TraficJemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TraficJemController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final TraficJemService traficJemService;
    @GetMapping("/traficJem/{idTraficJem}")
    public String traficJemPage(@PathVariable int idTraficJem, Model model){
        model.addAttribute("traficJemTitle", traficJemService.findByIdTitle(idTraficJem,
                httpSessionBean.getConnection()));
        return "traficJem-info";
    }
    @PostMapping("/traficJem/delete/{idTraficJem}")
    public String deleteTraficJem(@PathVariable int idTraficJem){
        traficJemService.delete(idTraficJem, httpSessionBean.getConnection());
        return "redirect:/traficJem";
    }
    @PostMapping("/traficJem/create")
    public String addTraficJem(TraficJem traficJem){
        traficJemService.save(traficJem, httpSessionBean.getConnection());
        return "redirect:/traficJem";
    }
//    @GetMapping("/traficJem/findByStop")
//    public String filterTraficJem(@RequestParam String stop, Model model){
//        model.addAttribute("traficJemByStop", traficJemService.filter(stop,
//                httpSessionBean.getConnection()));
//        return "redirect:/traficJem";
//    }
}
