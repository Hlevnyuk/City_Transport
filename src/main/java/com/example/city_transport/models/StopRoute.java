package com.example.city_transport.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopRoute {
    private int numberRoute;
    private int numberStop;
    private int stopOrder;
}
