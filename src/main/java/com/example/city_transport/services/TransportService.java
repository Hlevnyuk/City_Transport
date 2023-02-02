package com.example.city_transport.services;
import com.example.city_transport.models.Transport;
import com.example.city_transport.repositories.TransportRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TransportService {
    private final TransportRepositoryImpl transportRepositoryImpl;
    public List<Transport> transportList(Connection connection){
        return transportRepositoryImpl.findAll(connection);
    }
    public Transport getTransportByIdTransport(int idTransport, Connection connection){
        return transportRepositoryImpl.findById(idTransport, connection);
    }
    public void updateTransport(int idTransport, Connection connection){
        transportRepositoryImpl.updateTransport(idTransport, connection);
    }
    public List<Transport> findTransportByNumberRoute(int numberRoute, Connection connection){
        return transportRepositoryImpl.findTransportByNumberRoute(numberRoute, connection);
    }
    public List<Transport> findFreeTransport(int numberRoute, Connection connection){
        return transportRepositoryImpl.findFreeTransport(numberRoute, connection);
    }
    public void change(int idTransport, int numberTransport, String garage, Connection connection){
        transportRepositoryImpl.change(idTransport, numberTransport, garage, connection);
    }
    public List<Transport> findByIdContract(int idContract, Connection connection){
        return transportRepositoryImpl.findByIdContract(idContract, connection);
    }
    public List<Transport> emptyTransport(Connection connection){
        return transportRepositoryImpl.emptyTransport(connection);
    }
    public int countEmptyTransport(Connection connection){
        return transportRepositoryImpl.countEmptyTransport(connection);
    }
    public Transport findEmptyTransportByIdContract(int idContract, Connection connection){
        return findEmptyTransportByIdContract(idContract, connection);
    }
}
