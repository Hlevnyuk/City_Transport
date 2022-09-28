package com.example.city_transport.repositories;

import com.example.city_transport.models.Contract;
import com.example.city_transport.models.Firm;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class FirmRepositoryImpl implements FirmRepository {
    @Override
    public List<Firm> findAll(Connection connection) {
        List<Firm> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM firm
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Firm firm = new Firm();
                firm.setNameFirm(rs.getString("name_firm"));
                firm.setEmail(rs.getString("email"));
                firm.setAddress(rs.getString("adres"));
                firm.setDirector(rs.getString("director"));
                firm.setPhoneNumber(rs.getString("telephone"));
                listResult.add(firm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public void save(Firm firm, Connection connection) throws SQLException {
        String query = """
                       INSERT INTO firm
                       VALUES(?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, firm.getNameFirm());
            stmt.setString(2, firm.getEmail());
            stmt.setString(3, firm.getAddress());
            stmt.setString(4, firm.getDirector());
            stmt.setString(5, firm.getPhoneNumber());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String name, Connection connection) {
        String query = """
                        DELETE FROM firm
                        WHERE name_firm = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Firm findById(String name, Connection connection) {
        Firm firm = new Firm();
        String query = """
                        SELECT *
                        FROM firm
                        WHERE name_firm = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                firm.setNameFirm(rs.getString("name_firm"));
                firm.setEmail(rs.getString("email"));
                firm.setAddress(rs.getString("adres"));
                firm.setDirector(rs.getString("director"));
                firm.setPhoneNumber(rs.getString("telephone"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return firm;
    }
}
