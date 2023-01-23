package com.example.city_transport.repositories;

import com.example.city_transport.models.Stop;
import com.example.city_transport.models.StopRoute;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class StopRouteRepositoryImpl implements StopRouteRepository{
    @Override
    public List<StopRoute> findAll(Connection connection) {
        List<StopRoute> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM stop_route
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                StopRoute stopRoute = new StopRoute();
                stopRoute.setNumberRoute(rs.getInt("number_route"));
                stopRoute.setNumberStop(rs.getInt("number_stop"));
                listResult.add(stopRoute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public void save(StopRoute stopRoute, Connection connection) {
        String query = """
                       INSERT INTO stop_route
                       VALUES(?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, stopRoute.getNumberRoute());
            stmt.setInt(2, stopRoute.getNumberStop());
            stmt.setInt(3, stopRoute.getStopOrder());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int numberStop, int numberRoute, Connection connection) {
        String query = """
                        DELETE FROM stop_route
                        WHERE number_stop = ? AND number_route = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberStop);
            statement.setInt(2, numberRoute);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public StopRoute findById(int numberStop, Connection connection) {
        StopRoute stopRoute = new StopRoute();
        String query = """
                        SELECT *
                        FROM stop_route
                        WHERE number_stop = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberStop);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                stopRoute.setNumberRoute(rs.getInt("number_route"));
                stopRoute.setNumberStop(rs.getInt("number_stop"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return stopRoute;
    }

    @Override
    public int checkStopOrder(int numberRoute, Connection connection) {
        int max = 0;
        String query = """
                            SELECT MAX(stop_order) FROM stop_route
                            WHERE number_route = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, numberRoute);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                max = rs.getInt(1);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return max;
    }
    @Override
    public List<StopRoute> findByRoute(int numberRoute, Connection connection) {
        List<StopRoute> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM stop_route
                        WHERE number_route = ?
                       """;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, numberRoute);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                StopRoute stopRoute = new StopRoute();
                stopRoute.setNumberRoute(rs.getInt("number_route"));
                stopRoute.setNumberStop(rs.getInt("number_stop"));
                stopRoute.setStopOrder(rs.getInt("stop_order"));
                listResult.add(stopRoute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }
}
