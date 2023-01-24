package com.example.city_transport.repositories;

import com.example.city_transport.models.Stop;
import com.example.city_transport.models.StopRoute;
import org.apache.poi.hmef.attribute.MAPIAttribute;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StopRouteRepository {
    List<StopRoute> findAll(Connection connection);
    void save(StopRoute stopRoute, Connection connection) throws SQLException;
    void delete(int numberStop, int numberRoute, Connection connection);
    StopRoute findById(int numberRoute, Connection connection);
    int checkStopOrder(int numberRoute, Connection connection);
    List<StopRoute> findByRoute(int numberRoute, Connection connection);
    void updateStopOrder(int numberStop, int stopOrder, Connection connection);
//    List<Integer> stopOrderByNumberRoute(int numberRoute, Connection connection);
//    List<String> AddressByNumberRouteStopOrder(int numberRoute, Connection connection);
    Map<String, String> stopOrderAndAddress(int numberRoute, Connection connection);
}
