package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Contract;
import com.example.city_transport.services.ContractService;
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
    @PostMapping("/contract/create")
    public String addContract(Contract contract) throws SQLException {
        contractService.addContract(contract, httpSessionBean.getConnection());
        return "redirect:/contract";
    }
    @GetMapping("/contract/{id}")
    public String contractInfoPage(@PathVariable int id, Model model){
        model.addAttribute("contract", contractService.getById(id, httpSessionBean.getConnection()));
        return "contract-info";
    }
}
