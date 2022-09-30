package com.example.city_transport.repositories;

import com.example.city_transport.models.Route;
import com.example.city_transport.models.TraficJem;
import com.example.city_transport.models.TraficJemTitle;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class TraficJemRepositoryImpl implements TraficJemRepository{
    @Override
    public List<TraficJem> findAll(Connection connection) {
        List<TraficJem> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM trafic_jem
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TraficJem traficJem = new TraficJem();
                traficJem.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJem.setTimeStart(rs.getTime("time_start"));
                traficJem.setTimeEnd(rs.getTime("time_final"));
                traficJem.setNumberStop(rs.getInt("number_stop"));
                listResult.add(traficJem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }
    @Override
    public void save(TraficJem traficJem, Connection connection) {
        java.util.Date utilPackageDate1
                = traficJem.getTimeStart();
        java.sql.Time sqlDate1 = new java.sql.Time(utilPackageDate1.getTime());
        java.util.Date utilPackageDate2
                = traficJem.getTimeEnd();
        java.sql.Time sqlDate2 = new java.sql.Time(utilPackageDate2.getTime());
        String query = """
                       INSERT INTO trafic_jem
                       VALUES(?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, traficJem.getIdTraficJem());
            stmt.setInt(2, traficJem.getNumberEmployee());
            stmt.setTime(3, sqlDate1);
            stmt.setTime(4, sqlDate2);
            stmt.setInt(5, traficJem.getNumberStop());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void deleteById(int idTraficJem, Connection connection) {
        String query = """
                        DELETE 
                        FROM public.trafic_jem
                        WHERE id_trafic_jem = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, idTraficJem);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public TraficJem findById(int idTraficJem, Connection connection) {
        TraficJem traficJem = new TraficJem();
        String query = """
                        SELECT *
                        FROM public.trafic_jem
                        WHERE id_trafic_jem = ?
                       """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTraficJem);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                traficJem.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJem.setTimeStart(rs.getTime("time_start"));
                traficJem.setTimeEnd(rs.getTime("time_final"));
                traficJem.setNumberStop(rs.getInt("number_stop"));
                traficJem.setNumberEmployee(rs.getInt("number_employee"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return traficJem;
    }
    @Override
    public List<TraficJemTitle> findAllTraficJemTitle(Connection connection) {
        List<TraficJemTitle> listResult = new ArrayList<>();
        String query = """
                        SELECT DISTINCT id_trafic_jem, number_stop, adres, time_start, time_final
                        FROM trafic_jem_title
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TraficJemTitle traficJemTitle = new TraficJemTitle();
                traficJemTitle.setIdTraficJem(rs.getInt("id_trafic_jem"));
                //traficJemTitle.setNumberRoute(rs.getInt("number_route"));
                traficJemTitle.setNumberStop(rs.getInt("number_stop"));
                traficJemTitle.setAddress(rs.getString("adres"));
                traficJemTitle.setTimeStart(rs.getTime("time_start"));
                traficJemTitle.setTimeEnd(rs.getTime("time_final"));
                //traficJemTitle.setNumberEmployee(rs.getInt("number_employee"));
                listResult.add(traficJemTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public TraficJemTitle findByIdTitle(int idTraficJem, Connection connection) {
        TraficJemTitle traficJemTitle = new TraficJemTitle();
        String query = """
                        SELECT *
                        FROM trafic_jem_title
                        WHERE id_trafic_jem = ?
                       """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTraficJem);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                traficJemTitle.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJemTitle.setNumberRoute(rs.getInt("number_route"));
                traficJemTitle.setNumberStop(rs.getInt("number_stop"));
                traficJemTitle.setAddress(rs.getString("adres"));
                traficJemTitle.setTimeStart(rs.getTime("time_start"));
                traficJemTitle.setTimeEnd(rs.getTime("time_final"));
                traficJemTitle.setNumberEmployee(rs.getInt("number_employee"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return traficJemTitle;
    }

    @Override
    public List<TraficJemTitle> findByRouteId(int numberRoute, Connection connection){
        List<TraficJemTitle> listResult = new ArrayList<>();
        String query = """
                       SELECT * FROM trafic_jem_title
                       WHERE number_route = ?
                       """;
        try(PreparedStatement prst = connection.prepareStatement(query)){
            prst.setInt(1, numberRoute);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                TraficJemTitle traficJemTitle = new TraficJemTitle();
                traficJemTitle.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJemTitle.setNumberRoute(rs.getInt("number_route"));
                traficJemTitle.setNumberStop(rs.getInt("number_stop"));
                traficJemTitle.setAddress(rs.getString("adres"));
                traficJemTitle.setTimeStart(rs.getTime("time_start"));
                traficJemTitle.setTimeEnd(rs.getTime("time_final"));
                traficJemTitle.setNumberEmployee(rs.getInt("number_employee"));
                listResult.add(traficJemTitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listResult;
    }
    @Override
    public List<TraficJem> deleteByNumberRoute(int numberRoute, int numberStop, Connection connection){
        List<TraficJem> listResult = new ArrayList<>();
        String query = """
                        DELETE FROM trafic_jem
                        WHERE number_stop IN(SELECT number_stop FROM stop_route
                		WHERE number_route = ? AND number_stop = ?)
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, numberRoute);
            statement.setInt(2, numberStop);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return listResult;
    }
}
