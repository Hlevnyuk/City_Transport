package com.example.city_transport.repositories;

import com.example.city_transport.models.Administrator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class AdministratorRepositoryImpl implements AdministratorRepository{
    @Override
    public int findIdByLogin(String login, Connection connection) {
        int userId = 0;
        String query = """
                SELECT id_administrator FROM administrator
                WHERE email = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }
}
