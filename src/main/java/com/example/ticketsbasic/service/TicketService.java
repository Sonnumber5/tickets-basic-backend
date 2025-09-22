package com.example.ticketsbasic.service;

import com.example.ticketsbasic.domain.Ticket;
import com.example.ticketsbasic.repo.TicketRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository ticketRepository) {
        this.repo = ticketRepository;
    }

    @Async
    public CompletableFuture<List<Ticket>> listAllTickets() {
        return CompletableFuture.completedFuture(repo.findAll());
    }

    @Async
    public CompletableFuture<Ticket> getTicketById(Long id) {
        return CompletableFuture.completedFuture(repo.findById(id).orElse(null));
    }

    @Async
    public CompletableFuture<Ticket> createTicket(Ticket t) {
        return CompletableFuture.completedFuture(repo.save(t));
    }

    @Async
    public CompletableFuture<Ticket> updateTicket(Long id, Ticket data) {
        return CompletableFuture.completedFuture(
            repo.findById(id).map(t -> {
                t.setTitle(data.getTitle());
                t.setDescription(data.getDescription());
                t.setPriority(data.getPriority());
                t.setDueDate(data.getDueDate());
                return repo.save(t);
            }).orElse(null)
        );
    }

    @Async
    public CompletableFuture<Void> deleteTicket(Long id) {
        repo.deleteById(id);
        return CompletableFuture.completedFuture(null);
    }

}
