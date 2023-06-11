package com.example.city_transport.services;

import com.example.city_transport.repositories.EmployeeRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepositoryImpl employeeRepositoryImpl;
    public int findIdByLogin(String name, Connection connection){
        return employeeRepositoryImpl.findIdByLogin(name, connection);
    }
}
