package com.example.city_transport.services;

import com.example.city_transport.models.Stop;
import com.example.city_transport.models.StopRoute;
import com.example.city_transport.repositories.StopRouteRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StopRouteService {
    private final StopRouteRepositoryImpl stopRouteRepositoryImpl;
    public StopRoute getStopByNumberRoute(int numberRoute, Connection connection){
        return stopRouteRepositoryImpl.findById(numberRoute, connection);
    }
    public List<StopRoute> StopRouteList(Connection connection){
        return stopRouteRepositoryImpl.findAll(connection);
    }
    public void deleteStopRoute(int numberStop, Connection connection){
        stopRouteRepositoryImpl.deleteById(numberStop, connection);
    }
    public void addStopRoute(StopRoute stopRoute, Connection connection) {
        stopRouteRepositoryImpl.save(stopRoute, connection);
    }
}
