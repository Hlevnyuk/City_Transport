package com.example.city_transport.repositories;

import com.example.city_transport.models.TicketSold;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
@Component
public class TicketSoldRepositoryImpl implements TicketSoldRepository{
    @Override
    public List<TicketSold> findAll(Connection connection) {
        List<TicketSold> ticketSoldList = new ArrayList<>();
        String query = """
                       SELECT * FROM ticket_sold
                       """;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                TicketSold ticketSold = new TicketSold();
                ticketSold.setNumberTransport(rs.getInt("id_transport"));
                ticketSold.setDateSold(rs.getDate("date"));
                ticketSold.setKolTicketSold(rs.getInt("kol_ticket_sold"));
                ticketSold.setId(rs.getInt("id"));
                ticketSoldList.add(ticketSold);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticketSoldList;
    }

    @Override
    public void save(TicketSold ticketSold, Connection connection) {
        java.util.Date utilPackageDate
                = ticketSold.getDateSold();
        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        String query = """
                       INSERT INTO ticket_sold
                       VALUES(?, ?, ?)
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, ticketSold.getNumberTransport());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setInt(3, ticketSold.getKolTicketSold());
            int p = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
