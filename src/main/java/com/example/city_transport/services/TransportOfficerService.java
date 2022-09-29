package com.example.city_transport.services;

import com.example.city_transport.repositories.TransportOfficerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@RequiredArgsConstructor
public class TransportOfficerService {
    private final TransportOfficerRepositoryImpl tranaportOfficerRepositoryImpl;
    public int findIdByLogin(String name, Connection connection){
        return tranaportOfficerRepositoryImpl.findIdByLogin(name, connection);
    }
}
