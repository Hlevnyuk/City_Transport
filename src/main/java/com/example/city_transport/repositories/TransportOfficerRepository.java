package com.example.city_transport.repositories;

import java.sql.Connection;

public interface TransportOfficerRepository {
    int findIdByLogin(String login, Connection connection);
}
