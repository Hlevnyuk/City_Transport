package com.example.city_transport.bean;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Data
@SessionScope
@Component
public class HttpSessionBean {
    Connection connection;
    int id = 0;
    String role = "guest";
    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CityTransport?currentSchema = public",
                    "guest1", "guest1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}