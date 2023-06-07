package com.example.city_transport.repositories;

import com.example.city_transport.models.TraficJem;
import com.example.city_transport.models.TraficJemTitle;

import java.sql.Connection;
import java.util.List;

public interface TraficJemRepository{
    List<TraficJem> findAll(Connection connection);
    int save(TraficJem traficJem, Connection connection);
    void deleteById(int idTraficJem, Connection connection);
    TraficJem findById(int idTraficJem, Connection connection);
    List<TraficJemTitle> findByRouteId(int numberRoute, Connection connection);
    List<TraficJem> deleteByNumberRoute(int numberRoute, int numberStop, Connection connection);
    List<TraficJemTitle> findAllTraficJemTitle(Connection connection);
    TraficJemTitle findByIdTitle(int idTraficJem, Connection connection);

}
