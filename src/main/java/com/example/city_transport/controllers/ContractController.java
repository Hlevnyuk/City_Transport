package com.example.city_transport.controllers;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.documentConvert.Doc;
import com.example.city_transport.models.Contract;
import com.example.city_transport.services.ContractService;
import com.example.city_transport.services.TransportService;
import com.example.city_transport.services.TypeTransportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

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
    @PostMapping("/contract/update/end/date/{id}")
    public String contractUpdate(@PathVariable int id, @RequestParam Date dateEndContract, Model model){
        contractService.updateContract(dateEndContract, id, httpSessionBean.getConnection());
        model.addAttribute("role", httpSessionBean.getRole());
        return "redirect:/contract/{id}";
    }
    @GetMapping(value = "/download/file/{id}", produces = { "application/octet-stream" })
    public ResponseEntity<byte[]> download(@PathVariable int id) {
        try {
            String fileName = "contract" + id + ".docx";
            File file = ResourceUtils.getFile("contracts/" + fileName);
            byte[] contents = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename(fileName).build());
            return new ResponseEntity<>(contents, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}