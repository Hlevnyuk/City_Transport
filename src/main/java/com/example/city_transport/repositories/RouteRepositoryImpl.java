package com.example.city_transport.repositories;
import com.example.city_transport.models.Route;
import com.example.city_transport.models.RouteTitle;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class RouteRepositoryImpl implements RouteRepository{
    @Override
    public List<Route> findAll(Connection connection) {
        List<Route> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM route
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Route route = new Route();
                route.setNumberRoute(rs.getInt("number_route"));
                route.setInterval(rs.getString("interv"));
                route.setDateTime(rs.getDate("datetime"));
                route.setIdAdministrator(rs.getInt("id_administrator"));
                listResult.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }
    @Override
    public int save(Route route, Connection connection) {
        java.util.Date utilPackageDate
                = route.getDateTime();
        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        int id = 0;
        String query = """
                       INSERT INTO route(interv, datetime, id_administrator)
                       VALUES(?,?,?);
                       """;
        String query1 = """
                       SELECT last_value FROM route_number_route_seq;
                        """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, route.getInterval());
            stmt.setDate(2, sqlDate);
            stmt.setInt(3, route.getIdAdministrator());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query1);
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
    @Override
    public void updateInterval(String interval, int numberRoute, Connection connection) {
        String query = """
                       UPDATE route
                       SET interv = ? WHERE number_route = ?
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, interval);
            preparedStatement.setInt(2, numberRoute);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int numberRoute, Connection connection) {
        String query = """
                        DELETE FROM public.route
                        WHERE number_route = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberRoute);
            statement.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public Route findById(int numberRoute, Connection connection){
        Route route = new Route();
        String query = """
                        SELECT *
                        FROM public.route
                        WHERE number_route = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberRoute);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                route.setNumberRoute(rs.getInt("number_route"));
                route.setInterval(rs.getString("interv"));
                route.setDateTime(rs.getDate("datetime"));
                route.setIdAdministrator(rs.getInt("number_employee"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public List<RouteTitle> RouteStartAndEndPoint(Connection connection) {
        List<RouteTitle> list = new ArrayList<>();
        String query = """
                       SELECT * FROM route_title
                       """;
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                RouteTitle routeTitle = new RouteTitle();
                routeTitle.setNumberRoute(rs.getInt("number_route"));
                routeTitle.setStartPoint(rs.getString("start_point"));
                routeTitle.setEndPoint(rs.getString("end_point"));
                list.add(routeTitle);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public List<RouteTitle> findByAddress(int startPoint, int endPoint, Connection connection) {
        List<RouteTitle> list = new ArrayList<>();
        String query = """
                SELECT * FROM route_title\s
                WHERE number_route IN (SELECT number_route FROM stop_route\s
                WHERE number_stop = ?) AND number_route IN (SELECT number_route FROM stop_route\s
                WHERE number_stop = ?)
                       """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, startPoint);
            preparedStatement.setInt(2, endPoint);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                RouteTitle routeTitle = new RouteTitle();
                routeTitle.setNumberRoute(rs.getInt("number_route"));
                routeTitle.setStartPoint(rs.getString("start_point"));
                routeTitle.setEndPoint(rs.getString("end_point"));
                list.add(routeTitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
