package com.example.city_transport.repositories;

import com.example.city_transport.models.AnalizJem;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Date;
@Component
public class AnalizJemRepositoryImpl implements AnalizJemRepository{
    @Override
    public int analizRoute(int id, Date timeStart, Date timeFinal, Connection connection) {
        java.sql.Date sqlDate = new java.sql.Date(timeStart.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(timeFinal.getTime());
        String query = """
                       CALL analiz_jem(?, ?, ?, ?)
                       """;
        int kolTicketSold = 0;
        try(CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1, id);
            callableStatement.setObject(2, sqlDate);
            callableStatement.setObject(3, sqlDate1);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.execute();
            kolTicketSold = callableStatement.getInt(4);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kolTicketSold;
    }
}
