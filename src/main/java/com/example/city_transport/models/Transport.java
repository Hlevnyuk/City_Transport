package com.example.city_transport.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    private int idTransport;
    private int idContract;
    private int numberTransport;
    private String typeTransport;
    private String garage;
}
