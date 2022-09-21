//package com.example.city_transport.repositories;
//
//import com.example.city_transport.models.RoadRepair;
//import com.example.city_transport.models.TraficJem;
//import org.springframework.stereotype.Component;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//@Component
//public class RoadRepairRepositoryImpl implements RoadRepairRepository{
//
//    @Override
//    public List<RoadRepair> findAll(Connection connection) {
//        List<RoadRepair> listResult = new ArrayList<>();
//        String query = """
//                        SELECT *
//                        FROM road_repair
//                       """;
//        try (Statement stmt = connection.createStatement()) {
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                RoadRepair roadRepair = new RoadRepair();
//                roadRepair.setId(rs.getInt("id_roadrepair"));
//                roadRepair.setDateStartRoad(rs.getDate("date_startroad"));
//                roadRepair.setDateEndRoad(rs.getDate("date_endroad"));
//                listResult.add(roadRepair);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listResult;
//    }
//
//    @Override
//    public void save(RoadRepair roadRepair, Connection connection) throws SQLException {
//        java.util.Date utilPackageDate
//                = roadRepair.getDateStartRoad();
//        java.sql.Date sqlDate = new java.sql.Date(utilPackageDate.getTime());
//        java.util.Date utilPackageDate1
//                = roadRepair.getDateEndRoad();
//        java.sql.Date sqlDate1 = new java.sql.Date(utilPackageDate1.getTime());
//        String query = """
//                       INSERT INTO road_repair
//                       VALUES(?,?,?);
//                       """;
//        try(PreparedStatement stmt = connection.prepareStatement(query)){
//            stmt.setInt(1, roadRepair.getId());
//            stmt.setDate(2, sqlDate);
//            stmt.setDate(3, sqlDate1);
//            stmt.executeUpdate();
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void deleteById(int id, Connection connection) {
//        String query = """
//                        DELETE
//                        FROM public.road_repair
//                        WHERE id_roadrepair = ?
//                       """;
//        try(PreparedStatement statement = connection.prepareStatement(query)){
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public RoadRepair findById(int id, Connection connection) {
//        RoadRepair roadRepair = new RoadRepair();
//        String query = """
//                        SELECT *
//                        FROM public.road_repair
//                        WHERE id_roadrepair = ?
//                       """;
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                roadRepair.setId(rs.getInt("id_roadrepair"));
//                roadRepair.setDateStartRoad(rs.getDate("date_startroad"));
//                roadRepair.setDateEndRoad(rs.getDate("date_endroad"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return roadRepair;
//    }
//}
