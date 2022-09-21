package com.example.city_transport.repositories;

import com.example.city_transport.models.Transport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TransportRepository {
    List<Transport> findAll(Connection connection);
    List<Transport> findTransportByNumberRoute(int numberRoute, Connection connection);
    List<Transport> findFreeTransport(int numberRoute, Connection connection);
    void save(Transport transport, Connection connection) throws SQLException;
    void deleteById(int idTransport, Connection connection);
    Transport findById(int idTransport, Connection connection);
}
