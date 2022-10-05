package com.example.city_transport.repositories;

import com.example.city_transport.models.TicketSold;

import java.sql.Connection;
import java.util.List;

public interface TicketSoldRepository {
    List<TicketSold> findAll(Connection connection);
    void save(TicketSold ticketSold, Connection connection);
}
