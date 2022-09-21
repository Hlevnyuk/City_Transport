//package com.example.city_transport.services;
//import com.example.city_transport.models.RoadRepair;
//import com.example.city_transport.repositories.RoadRepairRepository;
//import com.example.city_transport.repositories.RoadRepairRepositoryImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//@Service
//@RequiredArgsConstructor
//public class RoadRepairService {
//    private final RoadRepairRepositoryImpl roadRepairRepositoryImpl;
//    public List<RoadRepair> roadRepairList(Connection connection){
//        return roadRepairRepositoryImpl.findAll(connection);
//    }
//    public void saveRoadRepair(RoadRepair roadRepair, Connection connection) throws SQLException {
//        roadRepairRepositoryImpl.save(roadRepair, connection);
//    }
//    public RoadRepair findById(int id, Connection connection){
//        return roadRepairRepositoryImpl.findById(id, connection);
//    }
//    public void delete(int id, Connection connection){
//        roadRepairRepositoryImpl.deleteById(id, connection);
//    }
//    public void stopOnRoadRepair(){
//        String query = """
//                       SELECT adres FROM stop
//                       WHERE number_stop IN(SELECT number_stop FROM road_repaironstop
//                       WHERE id_road_repaironstop IN(SELECT id_roadrepair FROM road_repair
//                       WHERE id_roadrepair =
//                       """;
//    }
//}
