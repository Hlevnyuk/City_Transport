package com.example.city_transport.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private int numberRoute;
    private String interval;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTime;
    private int idAdministrator;
}
