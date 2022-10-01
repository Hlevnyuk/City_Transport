package com.example.city_transport.repositories;

import com.example.city_transport.models.Contract;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    List<Contract> findAll(Connection connection);
    void save(Contract contract, Connection connection) throws SQLException;
    void deleteById(int id, Connection connection);
    Contract findById(int id, Connection connection);

}
