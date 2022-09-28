package com.example.city_transport.services;

import com.example.city_transport.models.Contract;
import com.example.city_transport.models.Firm;
import com.example.city_transport.repositories.FirmRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FirmService {
    private final FirmRepositoryImpl firmRepositoryImpl;
    public List<Firm> firmList(Connection connection){
        return firmRepositoryImpl.findAll(connection);
    }
    public Firm getByName(String name, Connection connection){
        return firmRepositoryImpl.findById(name, connection);
    }
    public void deleteFirm(String name, Connection connection){
        firmRepositoryImpl.deleteById(name, connection);
    }
    public void addFirm(Firm firm, Connection connection) throws SQLException {
        firmRepositoryImpl.save(firm, connection);
    }
}
