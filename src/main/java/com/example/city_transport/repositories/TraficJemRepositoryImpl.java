package com.example.city_transport.repositories;

import com.example.city_transport.models.TraficJem;
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
                        SELECT id_trafic_jem, stop, date_traficjem, start_point,
                        end_point, time_start, time_final, extent
                        FROM trafic_jem
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                TraficJem traficJem = new TraficJem();
                traficJem.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJem.setStop(rs.getString("stop"));
                traficJem.setDateTraficJem(rs.getDate("date_traficjem"));
                traficJem.setStartPoint(rs.getString("start_point"));
                traficJem.setEndPoint(rs.getString("end_point"));
                traficJem.setTimeStart(rs.getTime("time_start"));
                traficJem.setTimeEnd(rs.getTime("time_final"));
                traficJem.setExtent(rs.getInt("extent"));
                listResult.add(traficJem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }
    @Override
    public void save(TraficJem traficJem, Connection connection) {
        java.util.Date utilPackageDate
                = traficJem.getDateTraficJem();
        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        java.util.Date utilPackageDate1
                = traficJem.getTimeStart();
        java.sql.Time sqlDate1 = new java.sql.Time(utilPackageDate1.getTime());
        java.util.Date utilPackageDate2
                = traficJem.getTimeEnd();
        java.sql.Time sqlDate2 = new java.sql.Time(utilPackageDate2.getTime());
        String query = """
                       INSERT INTO trafic_jem
                       VALUES(?,?,?,?,?,?,?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, traficJem.getIdTraficJem());
            stmt.setString(2, traficJem.getStop());
            stmt.setDate(3, sqlDate);
            stmt.setString(4, traficJem.getStartPoint());
            stmt.setString(5, traficJem.getEndPoint());
            stmt.setInt(6, traficJem.getNumberEmployee());
            stmt.setInt(7, traficJem.getNumberStop());
            stmt.setTime(8, sqlDate1);
            stmt.setTime(9, sqlDate2);
            stmt.setInt(10, traficJem.getExtent());
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
            System.out.println("Record deleted successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public TraficJem findById(int idTraficJem, Connection connection) {
        TraficJem traficJem = new TraficJem();
        String query = """
                        SELECT id_trafic_jem, stop, date_traficjem, start_point,
                        end_point, time_start, time_final, extent
                        FROM public.trafic_jem
                        WHERE id_trafic_jem = ?
                       """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTraficJem);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                traficJem.setIdTraficJem(rs.getInt("id_trafic_jem"));
                traficJem.setStop(rs.getString("stop"));
                traficJem.setDateTraficJem(rs.getDate("date_traficjem"));
                traficJem.setStartPoint(rs.getString("start_point"));
                traficJem.setEndPoint(rs.getString("end_point"));
                traficJem.setTimeStart(rs.getTime("time_start"));
                traficJem.setTimeEnd(rs.getTime("time_final"));
                traficJem.setExtent(rs.getInt("extent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return traficJem;
    }
}
