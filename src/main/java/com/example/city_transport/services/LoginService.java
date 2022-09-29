package com.example.city_transport.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdministratorService administratorService;
    private final TransportOfficerService transportOfficerService;
    public Connection getConnection(String name, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/CityTransport", name, password);
    }
    public int getUserId(String name, Connection connection){
        int userId = 0;
        userId = administratorService.findIdByLogin(name, connection);
        if(userId == 0){
            userId = transportOfficerService.findIdByLogin(name, connection);
            if(userId == 0){
                    System.out.println("Login not found");
            }
        }

        return userId;
    }
    public String getRole(String name, Connection connection) throws SQLException {
        String role = "";
        String query = """
                SELECT rolname FROM pg_roles 
                WHERE pg_has_role( ?, oid, 'member') AND rolname != ?""";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            role = resultSet.getString(1);
        }
        return role;
    }
}