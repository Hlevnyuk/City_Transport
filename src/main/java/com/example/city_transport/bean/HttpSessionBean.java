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
    {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CityTransport?currentSchema = public",
                    "transport_officer", "transport_officer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}