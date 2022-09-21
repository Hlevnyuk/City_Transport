package com.example.city_transport.repositories;

import com.example.city_transport.models.Transport;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class TransportRepositoryImpl implements TransportRepository {
    @Override
    public List<Transport> findAll(Connection connection) {
        List<Transport> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM transport
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transport transport = new Transport();
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                transport.setGarage(rs.getString("garage"));
                transport.setIdContract(rs.getInt("id_contract"));
                listResult.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public List<Transport> findTransportByNumberRoute(int numberRoute, Connection connection) {
        List<Transport> list = new ArrayList<>();
        String query = """
                        SELECT id_transport, number_transport, type_transport FROM transport
                            WHERE id_transport IN (SELECT id_transport FROM setroute
                                WHERE number_route = ?)           
                        """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberRoute);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Transport transport = new Transport();
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                list.add(transport);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Transport> findFreeTransport(int numberRoute, Connection connection) {
        List<Transport> list = new ArrayList<>();
        String query = """
                        SELECT id_transport, number_transport FROM transport
                            WHERE id_transport NOT IN (SELECT id_transport FROM setroute)           
                        """;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                Transport transport = new Transport();
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                list.add(transport);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Transport transport, Connection connection) {
        String query = """
                       INSERT INTO transport
                       VALUES(?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, transport.getIdTransport());
            stmt.setInt(2, transport.getNumberTransport());
            stmt.setString(3, transport.getTypeTransport());
            stmt.setString(4, transport.getGarage());
            stmt.setInt(5, transport.getIdContract());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int idTransport, Connection connection) {
        String query = """
                        DELETE FROM transport
                        WHERE id_transport = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idTransport);
            statement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Transport findById(int idTransport, Connection connection) {
        Transport transport = new Transport();
        String query = """
                        SELECT *
                        FROM transport
                        WHERE id_transport = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idTransport);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                transport.setGarage(rs.getString("garage"));
                transport.setIdContract(rs.getInt("id_contract"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return transport;
    }

}
