package com.example.city_transport.repositories;

import com.example.city_transport.models.AnalizJem;

import java.sql.Connection;
import java.util.Date;

public interface AnalizJemRepository {
    int analizRoute(int id, Date timeStart, Date timeFinal, Connection connection);
}
