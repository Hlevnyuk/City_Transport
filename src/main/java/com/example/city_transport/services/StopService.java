package com.example.city_transport.services;

import java.util.ArrayList;

import com.example.city_transport.models.RouteTitle;
import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.Stop;
import com.example.city_transport.repositories.StopRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StopService {
    private final StopRepositoryImpl stopRepositoryImpl;
    public Stop getStopByNumberStop(int numberStop, Connection connection){
        return stopRepositoryImpl.findById(numberStop, connection);
    }
    public List<Stop> stopList(Connection connection){
        return stopRepositoryImpl.findAll(connection);
    }
    public void deleteStop(int numberStop, Connection connection){
        stopRepositoryImpl.deleteById(numberStop, connection);
    }
    public void addStop(Stop stop, Connection connection) {
        stopRepositoryImpl.save(stop, connection);
    }
    public List<Stop> findStopByNumberRoute(int numberRoute, Connection connection){
        return stopRepositoryImpl.findStopByNumberRoute(numberRoute, connection);
    }
    public List<Stop> findFreeByNumberRoute(int numberRoute, Connection connection){
        return stopRepositoryImpl.findFreeByNumberRoute(numberRoute, connection);
    }
}
