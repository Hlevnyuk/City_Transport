package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTransport {
    private String name;
    private int priceTicket;
    private int kolPlaces;
}
