package com.example.city_transport.services;

import com.example.city_transport.repositories.AdministratorRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@RequiredArgsConstructor
public class AdministratorService {
    private final AdministratorRepositoryImpl administratorRepositoryImpl;
    public int findIdByLogin(String name, Connection connection){
        return administratorRepositoryImpl.findIdByLogin(name, connection);
    }
}
