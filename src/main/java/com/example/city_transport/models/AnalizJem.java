package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalizJem {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeFinal;
}
