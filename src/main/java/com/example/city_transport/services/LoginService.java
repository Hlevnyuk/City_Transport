package com.example.city_transport.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
@RequiredArgsConstructor
public class LoginService{
    private final AdministratorService administratorService;
    private final TransportOfficerService transportOfficerService;
//    public boolean authenticate(String login, String pass) throws ClassNotFoundException, SQLException {
//        boolean rc = false;
//        Statement st = null;
//        ResultSet rs = null;
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection("jdbc:odbc:register");
//            String query = "SELECT username FROM registration WHERE username='" + login + "' AND password='" + pass + "';";
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            rc = rs.next();
//        } catch (SQLException e) {
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (st != null) {
//                st.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return rc;
//    }
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
//    public boolean getUser(String login, Connection connection) throws SQLException {
//        boolean result = false;
//        String user = "";
//        String query = """
//                       SELECT rolname FROM pg_roles
//                       WHERE rolname = ?
//                       """;
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1, login);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while(resultSet.next()){
//            user = resultSet.getString(1);
//        }
//        if(login.equals(user)){
//            result = true;
//        }
//        return result;
//    }
}