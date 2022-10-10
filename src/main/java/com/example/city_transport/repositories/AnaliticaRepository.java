package com.example.city_transport.repositories;

import com.example.city_transport.models.Analitica;

import java.sql.Connection;
import java.util.List;

public interface AnaliticaRepository {
    List<Analitica> findAll(Connection connection);
}
