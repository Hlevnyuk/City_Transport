package com.example.city_transport.repositories;

import com.example.city_transport.models.*;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class RoadRepairRepositoryImpl implements RoadRepairRepository{

    @Override
    public List<RoadRepair> findAll(Connection connection) {
        List<RoadRepair> listResult = new ArrayList<>();
        String query = """
                        SELECT *
                        FROM public.road_repair
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RoadRepair roadRepair = new RoadRepair();
                roadRepair.setIdRoadRepair(rs.getInt("id_roadrepair"));
                roadRepair.setDateStartRoad(rs.getDate("date_startroad"));
                roadRepair.setDateEndRoad(rs.getDate("date_endroad"));
                listResult.add(roadRepair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    @Override
    public void save(RoadRepair roadRepair, Connection connection) throws SQLException {
        java.util.Date utilPackageDate
                = roadRepair.getDateStartRoad();
        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
        java.util.Date utilPackageDate1
                = roadRepair.getDateEndRoad();
        java.sql.Date sqlDate1 = new java.sql.Date(utilPackageDate1.getTime());
        String query = """
                       INSERT INTO road_repair
                       VALUES(?,?,?,?);
                       """;
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, roadRepair.getIdRoadRepair());
            stmt.setDate(2, sqlDate);
            stmt.setDate(3, sqlDate1);
            stmt.setString(4, roadRepair.getAddres());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id, Connection connection) {
        String query = """
                        DELETE
                        FROM public.road_repair
                        WHERE id_roadrepair = ?
                       """;
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public RoadRepair findById(int id, Connection connection) {
        RoadRepair roadRepair = new RoadRepair();
        String query = """
                        SELECT *
                        FROM public.road_repair
                        WHERE id_roadrepair = ?
                       """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                roadRepair.setIdRoadRepair(rs.getInt("id_roadrepair"));
                roadRepair.setDateStartRoad(rs.getDate("date_startroad"));
                roadRepair.setDateEndRoad(rs.getDate("date_endroad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roadRepair;
    }

    @Override
    public List<RoadRepairTitle> findAllRoadRepairTitle(Connection connection) {
        List<RoadRepairTitle> list = new ArrayList<>();
        String query = """
                       SELECT DISTINCT id_roadrepair, adres, date_startroad, date_endroad FROM road_repair_title
                       """;
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                RoadRepairTitle roadRepairTitle = new RoadRepairTitle();
                roadRepairTitle.setIdRoadRepair(rs.getInt("id_roadrepair"));
                roadRepairTitle.setAddres(rs.getString("adres"));
                roadRepairTitle.setDateStartRoad(rs.getDate("date_startroad"));
                roadRepairTitle.setDateEndRoad(rs.getDate("date_endroad"));
                list.add(roadRepairTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<RoadRepairTitle> findByRouteId(int numberRoute, Connection connection){
        List<RoadRepairTitle> listResult = new ArrayList<>();
        String query = """
                       SELECT * FROM road_repair_title
                       WHERE number_route = ?
                       """;
        try(PreparedStatement prst = connection.prepareStatement(query)){
            prst.setInt(1, numberRoute);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                RoadRepairTitle roadRepairTitle = new RoadRepairTitle();
                roadRepairTitle.setIdRoadRepair(rs.getInt("id_roadrepair"));
                roadRepairTitle.setNumberRoute(rs.getInt("number_route"));
                roadRepairTitle.setAddres(rs.getString("adres"));
                roadRepairTitle.setNumberStop(rs.getInt("number_stop"));
                roadRepairTitle.setDateStartRoad(rs.getDate("date_startroad"));
                roadRepairTitle.setDateEndRoad(rs.getDate("date_endroad"));
                listResult.add(roadRepairTitle);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listResult;
    }

    @Override
    public RoadRepairTitle findByIdTitle(int id, Connection connection) {
        RoadRepairTitle roadRepairTitle = new RoadRepairTitle();
        String query = """
                            SELECT * FROM road_repair_title
                            WHERE id_roadrepair = ?
                       """;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                roadRepairTitle.setIdRoadRepair(rs.getInt("id_roadrepair"));
                roadRepairTitle.setNumberRoute(rs.getInt("number_route"));
                roadRepairTitle.setAddres(rs.getString("adres"));
                roadRepairTitle.setNumberStop(rs.getInt("number_stop"));
                roadRepairTitle.setDateStartRoad(rs.getDate("date_startroad"));
                roadRepairTitle.setDateEndRoad(rs.getDate("date_endroad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roadRepairTitle;
    }

    @Override
    public List<RoadRepair> deleteByNumberRoute(int numberRoute, int numberStop, Connection connection){
        List<RoadRepair> listResult = new ArrayList<>();
        String query = """
                 DELETE FROM road_repair
                    WHERE id_roadrepair IN(SELECT id_road_repaironstop FROM road_repaironstop
                 	    WHERE number_stop IN(SELECT number_stop FROM stop
                 		    WHERE number_stop IN(SELECT number_stop FROM stop_route
                 			    WHERE number_route = ? AND number_stop = ?)))
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

//    @Override
//    public void saveRoadRepairOnStop(RoadRepairOnStop roadRepairOnStop, Connection connection) {
//        String query = """
//                       INSERT INTO road_repaironstop
//                       VALUES(?,?);
//                       """;
//        try(PreparedStatement stmt = connection.prepareStatement(query)){
//            stmt.setInt(1, roadRepairOnStop.getIdRepairOnStop());
//            stmt.setInt(2, roadRepairOnStop.getNumberStop());
//            stmt.executeUpdate();
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
}