package com.example.city_transport.services;

import com.example.city_transport.models.TicketSold;
import com.example.city_transport.repositories.TicketSoldRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketSoldService {
    private final TicketSoldRepositoryImpl ticketSoldRepositoryImpl;
    public List<TicketSold> findAll(Connection connection){
        return ticketSoldRepositoryImpl.findAll(connection);
    }
    public void save(TicketSold ticketSold, Connection connection){
        ticketSoldRepositoryImpl.save(ticketSold, connection);
    }
}
