package com.example.city_transport.repositories;

import com.example.city_transport.models.SetRoute;
import com.example.city_transport.models.Stop;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class StopRepositoryImpl implements StopRepository{
    @Override
    public List<Stop> findAll(Connection connection) {
        List<Stop> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM stop
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Stop stop = new Stop();
                stop.setNumberStop(rs.getInt("number_stop"));
                stop.setAddress(rs.getString("adres"));
                listResult.add(stop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public List<Stop> findFreeByNumberRoute(int numberRoute, Connection connection) {
        List<Stop> list = new ArrayList<>();
        String query = """
                        SELECT * FROM stop
                            WHERE number_stop NOT IN (SELECT number_stop FROM stop_route
                                WHERE number_route = ?)           
                        """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, numberRoute);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Stop stop = new Stop();
                stop.setNumberStop(rs.getInt("number_stop"));
                stop.setAddress(rs.getString("adres"));
                list.add(stop);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> findStopByNumberRoute(int numberRoute, Connection connection) {
        List<String> list = new ArrayList<>();
        String query = """
                        SELECT adres FROM stop
                	        WHERE number_stop IN(SELECT number_stop FROM stop_route
                					WHERE number_route = ?)
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberRoute);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                list.add(rs.getString("adres"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Stop stop, Connection connection) {
        String query = """
                       INSERT INTO stop
                       VALUES(?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, stop.getNumberStop());
            stmt.setString(2, stop.getAddress());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            System.out.println("Такой номер маршрута уже существует");

        }
    }

    @Override
    public void deleteById(int numberStop, Connection connection) {
        String query = """
                        DELETE FROM stop
                        WHERE number_stop = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberStop);
            statement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Stop findById(int numberStop, Connection connection) {
        Stop stop = new Stop();
        String query = """
                        SELECT *
                        FROM stop
                        WHERE number_stop = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberStop);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                stop.setNumberStop(rs.getInt("number_stop"));
                stop.setAddress(rs.getString("adres"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return stop;
    }
}
