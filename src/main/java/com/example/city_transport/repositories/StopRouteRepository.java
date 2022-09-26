package com.example.city_transport.repositories;

import com.example.city_transport.models.Stop;
import com.example.city_transport.models.StopRoute;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StopRouteRepository {
    List<StopRoute> findAll(Connection connection);
    void save(StopRoute stopRoute, Connection connection) throws SQLException;
    void delete(int numberStop, int numberRoute, Connection connection);
    StopRoute findById(int numberRoute, Connection connection);
}
