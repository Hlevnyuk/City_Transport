package com.example.city_transport.repositories;

import com.example.city_transport.models.Route;
import com.example.city_transport.models.RouteTitle;
import com.example.city_transport.models.Stop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public interface RouteRepository{
    List<Route> findAll(Connection connection);
    void save(Route route, Connection connection) throws SQLException;
    void deleteById(int numberRoute, Connection connection);
    Route findById(int numberRoute, Connection connection);
    List<RouteTitle> RouteStartAndEndPoint(Connection connection);
    List<RouteTitle> findByAddress(int startPoint, int endPoint, Connection connection);
    void updateInterval(String interval, int numberRoute, Connection connection);
}
