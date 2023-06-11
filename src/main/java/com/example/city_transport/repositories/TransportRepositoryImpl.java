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
    @Override
    public void change(int idTransport, int numberTransport, String garage, Connection connection){
        String query = """
                       UPDATE transport
                       SET number_transport = ?, garage = ?
                       WHERE id_transport = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberTransport);
            statement.setString(2, garage);
            statement.setInt(3, idTransport);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Transport> findByIdContract(int idContract, Connection connection) {
        List<Transport> transportList = new ArrayList<>();
        String query = """
                    SELECT * FROM transport
                        WHERE id_contract IN(SELECT id_contract FROM contract
                			WHERE id_contract = ?)
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, idContract);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Transport transport = new Transport();
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                transport.setGarage(rs.getString("garage"));
                transport.setIdContract(rs.getInt("id_contract"));
                transportList.add(transport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return transportList;
    }

    @Override
    public List<Transport> emptyTransport(Connection connection) {
        List<Transport> transportList = new ArrayList<>();
        String query = """
                       SELECT * FROM transport
                          WHERE number_transport IS null OR garage IS null
                       """;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Transport transport = new Transport();
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                transport.setGarage(rs.getString("garage"));
                transport.setIdContract(rs.getInt("id_contract"));
                transportList.add(transport);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transportList;
    }

    @Override
    public void updateTransport(int idTransport, Connection connection) {
        String query = """
                       UPDATE transport SET number_transport = null, garage = null WHERE id_transport = ?
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, idTransport);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int countEmptyTransport(Connection connection) {
        int result = 0;
        String query = """
                       SELECT COUNT(*) AS total FROM transport
                       WHERE number_transport IS null AND garage IS null
                       """;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                result = rs.getInt("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Transport findEmptyTransportByIdContract(int idContract, Connection connection) {
        Transport transport = new Transport();
        String query = """
                        SELECT * FROM transport
                        WHERE id_contract = ? AND garage IS null AND number_transport IS null
                        LIMIT 1
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, idContract);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                transport.setIdTransport(rs.getInt("id_transport"));
                transport.setNumberTransport(rs.getInt("number_transport"));
                transport.setTypeTransport(rs.getString("type_transport"));
                transport.setGarage(rs.getString("garage"));
                transport.setIdContract(rs.getInt("id_contract"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transport;
    }
}
