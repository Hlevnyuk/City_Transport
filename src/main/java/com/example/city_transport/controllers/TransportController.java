package com.example.city_transport.controllers;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Transport;
import com.example.city_transport.services.TransportService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Controller
public class TransportController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    @Autowired
    private TransportService transportService;
    @GetMapping("/transport")
    public String transportPage(Model model){
        List<Transport> transportList2 = new ArrayList<>();
        List<Transport> transportList = transportService.transportList(httpSessionBean.getConnection())
                .stream().filter(el -> el.getNumberTransport() == 0 &&
                        el.getGarage() == null).toList();
        model.addAttribute("transport", transportService.transportList(httpSessionBean.getConnection())
                .stream().filter(el -> el.getNumberTransport() != 0 &&
                        el.getGarage() != null).toList());
        Set<Integer> set = new HashSet<>();
        transportList.forEach(x -> set.add(x.getIdContract()));
        transportList.forEach(y -> {
            if(set.contains(y.getIdContract())){
                transportList2.add(y);
                set.remove(y.getIdContract());
            }
        });
        model.addAttribute("transportChange", transportList2);
        model.addAttribute("transportForm", new Gson().toJson(transportList2));
        return "transport";
    }
    @PostMapping("/transport/change")
    public String transportChange(@RequestParam int idTransport, @RequestParam int numberTransport,
                                  @RequestParam String garage){
        transportService.change(idTransport, numberTransport, garage, httpSessionBean.getConnection());
        return "redirect:/transport";
    }
    @PostMapping("/transport/update/{idTransport}")
    public String transportDelete(@PathVariable int idTransport){
        transportService.updateTransport(idTransport, httpSessionBean.getConnection());
        return "redirect:/transport";
    }
}