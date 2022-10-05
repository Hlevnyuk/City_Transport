package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketSold {
    private int idTransport;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateSold;
    private int kolTicketSold;
    private int id;
}
