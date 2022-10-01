package com.example.city_transport.services;

import com.example.city_transport.models.AnalizJem;
import com.example.city_transport.repositories.AnalizJemRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FunctionsService {
    private final AnalizJemRepositoryImpl analizJemRepositoryImpl;
    public int analizRoute(int id, Date timeStart, Date timeFinal, Connection connection){
        return analizJemRepositoryImpl.analizRoute(id, timeStart, timeFinal, connection);
    }
}
