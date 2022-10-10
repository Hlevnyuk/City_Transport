package com.example.city_transport.services;

import com.example.city_transport.bean.HttpSessionBean;
import com.example.city_transport.models.Analitica;
import com.example.city_transport.repositories.AnaliticaRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnaliticaService {
    @Autowired
    private HttpSessionBean httpSessionBean;
    private final AnaliticaRepositoryImpl analiticaRepositoryImpl;
    public List<Analitica> findAll(Connection connection){
        return analiticaRepositoryImpl.findAll(connection);
    }
}
