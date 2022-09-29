package com.example.city_transport.repositories;

import com.example.city_transport.models.Administrator;

import java.sql.Connection;

public interface AdministratorRepository {
    int findIdByLogin(String login, Connection connection);
}
