package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraficJemTitle {
    private int idTraficJem;
    private int numberRoute;
    private int numberStop;
    private String address;
    @DateTimeFormat(pattern = "HH:mm")
    private Date timeStart;
    @DateTimeFormat(pattern = "HH:mm")
    private Date timeEnd;
    private int numberEmployee;
}
