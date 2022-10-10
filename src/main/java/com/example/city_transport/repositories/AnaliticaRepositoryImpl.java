package com.example.city_transport.repositories;

import com.example.city_transport.models.Analitica;
import com.example.city_transport.models.Route;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnaliticaRepositoryImpl implements AnaliticaRepository{
    @Override
    public List<Analitica> findAll(Connection connection) {
        List<Analitica> listResult = new ArrayList<>();
        String query = """
                       SELECT * FROM analitica()
                       """;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Analitica analitica = new Analitica();
                analitica.setNumberRouteR(rs.getInt(1));
                analitica.setKolTicketSoldR(rs.getInt(2));
                listResult.add(analitica);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listResult;
    }
}
