package com.example.city_transport.repositories;


import com.example.city_transport.models.Firm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FirmRepository {
    List<Firm> findAll(Connection connection);
    void save(Firm firm, Connection connection) throws SQLException;
    void deleteById(String name, Connection connection);
    Firm findById(String name, Connection connection);
}
