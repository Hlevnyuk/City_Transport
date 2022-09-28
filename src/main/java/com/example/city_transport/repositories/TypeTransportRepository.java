package com.example.city_transport.repositories;

import com.example.city_transport.models.Firm;
import com.example.city_transport.models.TypeTransport;

import java.sql.Connection;
import java.util.List;

public interface TypeTransportRepository {
    List<TypeTransport> findAll(Connection connection);
}
