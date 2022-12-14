package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.documentConvert.Doc;
import com.example.city_transport.models.Contract;
import com.example.city_transport.services.ContractService;
import com.example.city_transport.services.TransportService;
import com.example.city_transport.services.TypeTransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.SQLException;

@Controller
@RequiredArgsConstructor
public class ContractController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final ContractService contractService;
    private final TransportService transportService;
    private final TypeTransportService typeTransportService;
    private final Doc doc;
    @GetMapping("/contract/page/create")
    public String pageCreateContract(Model model){
        model.addAttribute("contract", contractService.contractList(httpSessionBean.getConnection()));
        model.addAttribute("typeTransport", typeTransportService.transportList(httpSessionBean.getConnection()));
        model.addAttribute("role", httpSessionBean.getRole());
        return "createContract";
    }
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
    @PostMapping("/download/file/{id}/{typeTransport}/{transportCount}/{dateStartContract}/{dateEndContract}/{firm}")
    public String download(@PathVariable int id, @PathVariable String typeTransport, @PathVariable int transportCount,
                           @PathVariable String dateStartContract, @PathVariable String dateEndContract, @PathVariable String firm, Model model){
        model.addAttribute("contract", contractService.getById(id, httpSessionBean.getConnection()));
        model.addAttribute("transport", transportService.findByIdContract(id,
                httpSessionBean.getConnection()));
          doc.file(id, typeTransport, transportCount, dateStartContract, dateEndContract, firm);
        return "contract-info";
    }
    @PostMapping("/contract/update/end/date/{id}")
    public String contractUpdate(@PathVariable int id, @RequestParam Date dateEndContract, Model model){
        contractService.updateContract(dateEndContract, id, httpSessionBean.getConnection());
        model.addAttribute("role", httpSessionBean.getRole());
        return "redirect:/contract/{id}";
    }
//    @PostMapping("/contract/update/{id}")
//    public String updateValidity(@RequestParam Date dateEndContract, @PathVariable int id, Model model){
//        model.addAttribute("contract", contractService.updateContract(dateEndContract, id, httpSessionBean.getConnection()));
//        return "contract-info";
//    }
}
