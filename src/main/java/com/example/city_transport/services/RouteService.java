package com.example.city_transport.services;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.RouteTitle;
import com.example.city_transport.repositories.RouteRepository;
import com.example.city_transport.repositories.RouteRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepositoryImpl routeRepositoryImpl;
    public List<Route> routeList(Connection connection){
        return routeRepositoryImpl.findAll(connection);
    }
    public Route getRouteByNumberRoute(int numberRoute, Connection connection){
        return routeRepositoryImpl.findById(numberRoute, connection);
    }
    public void deleteRoute(int numberRoute, Connection connection){
        routeRepositoryImpl.deleteById(numberRoute, connection);
    }
    public void addRoute(Route route, Connection connection){
        routeRepositoryImpl.save(route, connection);
    }

    public List<RouteTitle> routeTitleList(Connection connection){
        return routeRepositoryImpl.RouteStartAndEndPoint(connection);
    }
    public List<RouteTitle> findByAddress(int startPoint, int endPoint, Connection connection){
        return routeRepositoryImpl.findByAddress(startPoint, endPoint, connection);
    }
}
