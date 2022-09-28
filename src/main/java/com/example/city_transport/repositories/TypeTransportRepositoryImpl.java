package com.example.city_transport.repositories;

import com.example.city_transport.models.Firm;
import com.example.city_transport.models.TypeTransport;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class TypeTransportRepositoryImpl implements TypeTransportRepository{
    @Override
    public List<TypeTransport> findAll(Connection connection) {
        List<TypeTransport> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM type_transport
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TypeTransport typeTransport = new TypeTransport();
                typeTransport.setName(rs.getString("name"));
                typeTransport.setPriceTicket(rs.getInt("price_ticket"));
                typeTransport.setKolPlaces(rs.getInt("kol_places"));
                listResult.add(typeTransport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }
}
