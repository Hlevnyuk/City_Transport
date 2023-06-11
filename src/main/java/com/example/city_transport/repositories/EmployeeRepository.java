package com.example.city_transport.repositories;

import java.sql.Connection;

public interface EmployeeRepository {
    int findIdByLogin(String login, Connection connection);
}
