package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoadRepair {
    private int idRoadRepair;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateStartRoad;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEndRoad;
    private String addres;
}
