package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraficJem {
    private int idTraficJem;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private int numberEmployee;
    private int numberStop;
    @DateTimeFormat(pattern = "HH:mm")
    private Date timeStart;
    @DateTimeFormat(pattern = "HH:mm")
    private Date timeEnd;
}
