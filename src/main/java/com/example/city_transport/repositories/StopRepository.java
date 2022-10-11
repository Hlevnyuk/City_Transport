package com.example.city_transport.repositories;

import com.example.city_transport.models.Route;
import com.example.city_transport.models.RouteTitle;
import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.Stop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface StopRepository {
    List<Stop> findAll(Connection connection);
    List<Stop> findFreeByNumberRoute(int numberRoute, Connection connection);
    List<Stop> findStopByNumberRoute(int numberRoute, Connection connection);
    void save(Stop stop, Connection connection) throws SQLException;
    void deleteById(int numberStop, Connection connection);
    Stop findById(int numberStop, Connection connection);
}
