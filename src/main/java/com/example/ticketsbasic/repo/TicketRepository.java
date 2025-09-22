package com.example.ticketsbasic.repo;

import com.example.ticketsbasic.domain.Ticket;
import org.springframework.data.repository.ListCrudRepository;

// JDBC repository; inherits CRUD for Ticket
public interface TicketRepository extends ListCrudRepository<Ticket, Long> { }
