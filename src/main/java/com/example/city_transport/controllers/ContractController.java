package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Contract;
import com.example.city_transport.services.ContractService;
import com.example.city_transport.services.TransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class ContractController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final ContractService contractService;
    private final TransportService transportService;
    @PostMapping("/contract/create")
    public String addContract(Contract contract) throws SQLException {
        contractService.addContract(contract, httpSessionBean.getConnection());
        return "redirect:/contract";
    }
    @GetMapping("/contract/{id}")
    public String contractInfoPage(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.getById(id, httpSessionBean.getConnection()));
        model.addAttribute("transport", transportService.findByIdContract(id,
                httpSessionBean.getConnection()));
        return "contract-info";
    }
    @PostMapping("/contract/delete/{id}")
    public String contractDelete(@PathVariable int id){
        contractService.deleteContract(id, httpSessionBean.getConnection());
        return "redirect:/contract";
    }
//    @GetMapping("/contract/by/transport/{id}")
//    public String contractTransportInfo(@PathVariable int id){
//
//    }
}
