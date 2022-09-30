package com.example.city_transport.repositories;

import com.example.city_transport.models.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RoadRepairRepository {
    List<RoadRepair>  findAll(Connection connection);
    void save(RoadRepair roadRepair, Connection connection) throws SQLException;
    void deleteById(int id, Connection connection);
    RoadRepair findById(int id, Connection connection);
    List<RoadRepairTitle> findByRouteId(int numberRoute, Connection connection);
    List<RoadRepair> deleteByNumberRoute(int numberRoute, int numberStop, Connection connection);
    void saveRoadRepairOnStop(RoadRepairOnStop roadRepairOnStop, Connection connection);
}
