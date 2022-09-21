package com.example.city_transport.services;

import com.example.city_transport.models.Route;
import com.example.city_transport.models.TraficJem;
import com.example.city_transport.models.TraficJemTitle;
import com.example.city_transport.repositories.TraficJemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class TraficJemService {
    @Autowired
    private TraficJemRepositoryImpl traficJemRepositoryImpl;
    public List<TraficJem> traficJemList(Connection connection){
        return traficJemRepositoryImpl.findAll(connection);
    }
    public TraficJem findById(int idTraficJem, Connection connection){
        return traficJemRepositoryImpl.findById(idTraficJem, connection);
    }
    public void delete(int idTraficJem, Connection connection){
        traficJemRepositoryImpl.deleteById(idTraficJem, connection);
    }
    public void save(TraficJem traficJem, Connection connection){
        traficJemRepositoryImpl.save(traficJem, connection);
    }
    public List<TraficJemTitle> findByRouteId(int numberRoute, Connection connection){
        return traficJemRepositoryImpl.findByRouteId(numberRoute, connection);
    }
}
