package com.example.city_transport.services;

import com.example.city_transport.models.Contract;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.RouteTitle;
import com.example.city_transport.repositories.ContractRepository;
import com.example.city_transport.repositories.ContractRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepositoryImpl contractRepositoryImpl;
    public List<Contract> contractList(Connection connection){
        return contractRepositoryImpl.findAll(connection);
    }
    public Contract getById(int id, Connection connection){
        return contractRepositoryImpl.findById(id, connection);
    }
    public void deleteContract(int id, Connection connection){
        contractRepositoryImpl.deleteById(id, connection);
    }
    public void addContract(Contract contract, Connection connection) throws SQLException {
        contractRepositoryImpl.save(contract, connection);
    }
}
