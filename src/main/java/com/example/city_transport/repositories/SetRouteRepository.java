package com.example.city_transport.repositories;
import com.example.city_transport.models.SetRoute;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SetRouteRepository {
    List<SetRoute> findAll(Connection connection);
    void save(SetRoute setRoute, Connection connection) throws SQLException;
    void deleteById(int idTransport, Connection connection);
    SetRoute findById(int idTransport, Connection connection);
}
