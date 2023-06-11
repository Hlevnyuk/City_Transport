package com.example.city_transport.repositories;

import com.example.city_transport.models.SetRoute;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class SetRouteRepositoryImpl implements SetRouteRepository{
    @Override
    public List<SetRoute> findAll(Connection connection) {
        List<SetRoute> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM setroute
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SetRoute setRoute = new SetRoute();
                setRoute.setNumberRoute(rs.getInt("number_route"));
                setRoute.setIdTransport(rs.getInt("id_transport"));
                listResult.add(setRoute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public void save(SetRoute setRoute, Connection connection) {
        String query = """
                       INSERT INTO setroute
                       VALUES(?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, setRoute.getNumberRoute());
            stmt.setInt(2, setRoute.getIdTransport());
//            stmt.setInt(3, setRoute.getNumberTransport());
            int p = stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int idTransport, Connection connection) {
        String query = """
                        DELETE FROM setroute
                        WHERE id_transport = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idTransport);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public SetRoute findById(int idTransport, Connection connection) {
        SetRoute setRoute = new SetRoute();
        String query = """
                        SELECT *
                        FROM setroute
                        WHERE id_transport = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idTransport);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                setRoute.setNumberRoute(rs.getInt("number_route"));
                setRoute.setIdTransport(rs.getInt("id_transport"));
//                setRoute.setNumberTransport(rs.getInt("number_transport"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return setRoute;
    }
}
