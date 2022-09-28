package com.example.city_transport.services;

import com.example.city_transport.models.Transport;
import com.example.city_transport.models.TypeTransport;
import com.example.city_transport.repositories.TypeTransportRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeTransportService {
    private final TypeTransportRepositoryImpl typeTransportRepositoryImpl;
    public List<TypeTransport> transportList(Connection connection){
        return typeTransportRepositoryImpl.findAll(connection);
    }
}
