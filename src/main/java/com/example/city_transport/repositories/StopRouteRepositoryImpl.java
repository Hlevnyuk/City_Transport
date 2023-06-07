package com.example.city_transport.repositories;

import com.example.city_transport.models.Stop;
import com.example.city_transport.models.StopRoute;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class StopRouteRepositoryImpl implements StopRouteRepository{
    @Override
    public List<StopRoute> findAll(Connection connection) {
        List<StopRoute> listResult = new ArrayList<>();
        String query = """
                        SELECT * FROM stop_route
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

    @Override
    public void updateStopOrder(int numberStop, int stopOrder, int numberRoute, Connection connection) {
        String query = """
                       UPDATE stop_route
                       SET number_stop = ? WHERE stop_order = ? AND number_route = ?
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, numberStop);
            preparedStatement.setInt(2, stopOrder);
            preparedStatement.setInt(3, numberRoute);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Map<String, String> stopOrderAndAddress(int numberRoute, Connection connection) {
        Map<String, String> map = new LinkedHashMap<>();
        String query = """
                        SELECT sr.stop_order, st.adres FROM stop_route sr
                        JOIN stop st ON sr.number_stop = st.number_stop
                        WHERE sr.number_route = ?
                        ORDER BY stop_order ASC
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, numberRoute);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                map.put(Integer.toString(rs.getInt(1)), rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

//    @Override
//    public List<Integer> stopOrderByNumberRoute(int numberRoute, Connection connection) {
//        List<Integer> list = new ArrayList<>();
//        String query = """
//                       SELECT stop_order FROM stop_route
//                       WHERE number_route = ?
//                       ORDER BY stop_order ASC
//                       """;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
//            preparedStatement.setInt(1, numberRoute);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                list.add(rs.getInt(1));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return list;
//    }
//
//    @Override
//    public List<String> AddressByNumberRouteStopOrder(int numberRoute, Connection connection) {
//        List<String> list = new ArrayList<>();
//        String query = """
//                        SELECT adres FROM stop
//                                       WHERE number_stop IN(SELECT number_stop FROM stop_route
//                                       					WHERE number_route = ?
//                                       					ORDER BY stop_order ASC)
//                       """;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
//            preparedStatement.setInt(1, numberRoute);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                list.add(rs.getString(1));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return list;
//    }
}
