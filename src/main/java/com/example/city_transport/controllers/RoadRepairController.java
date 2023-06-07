package com.example.city_transport.controllers;
import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.RoadRepair;
import com.example.city_transport.services.RoadRepairService;
import com.example.city_transport.services.StopService;
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
public class RoadRepairController {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final RoadRepairService roadRepairService;
    private final StopService stopService;
    @GetMapping("/roadRepair/{id}")
    public String roadRepairPage(@PathVariable int id, Model model){
        model.addAttribute("roadRepairTitle", roadRepairService.findByIdTitle(id,
                httpSessionBean.getConnection()));
        return "roadRepair-info";
    }
    @PostMapping("/roadRepair/add")
    public String roadRepairAdd(RoadRepair roadRepair) throws SQLException {
        roadRepairService.saveRoadRepair(roadRepair, httpSessionBean.getConnection());
        return "redirect:/roadRepair";
    }
    @PostMapping("/roadRepair/delete/{id}")
    public String roadRepairDelete(@PathVariable int id){
        roadRepairService.delete(id, httpSessionBean.getConnection());
        return "redirect:/roadRepair";
    }
}