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
    public void deleteById(int numberStop, Connection connection) {
        String query = """
                        DELETE FROM stopRoute
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
    public StopRoute findById(int numberStop, Connection connection) {
        StopRoute stopRoute = new StopRoute();
        String query = """
                        SELECT *
                        FROM stopRoute
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
}
