package com.example.city_transport.services;

import com.example.city_transport.models.Route;
import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.Transport;
import com.example.city_transport.repositories.SetRouteRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SetRouteService {
    private final SetRouteRepositoryImpl setRouteRepositoryImpl;
    public SetRoute getSetRouteByIdTransport(int idTransport, Connection connection){
        return setRouteRepositoryImpl.findById(idTransport, connection);
    }
    public List<SetRoute> SetRouteList(Connection connection){
        return setRouteRepositoryImpl.findAll(connection);
    }
    public void deleteSetRoute(int idTransport, Connection connection){
        setRouteRepositoryImpl.deleteById(idTransport, connection);
    }
    public void addSetRoute(SetRoute setRoute, Connection connection) {
        setRouteRepositoryImpl.save(setRoute, connection);
    }
}
