package com.example.ticketsbasic.web;

import com.example.ticketsbasic.domain.Ticket;
import com.example.ticketsbasic.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"*"})
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    // list all tickets
    @GetMapping
    public CompletableFuture<List<Ticket>> list() {
        return service.listAllTickets();
    }

    // get one ticket by id
    @GetMapping("/{ticket_id}")
    public CompletableFuture<ResponseEntity<Ticket>> get(@PathVariable("ticket_id") Long id) {
        return service.getTicketById(id)
                .thenApply(ticket -> ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build());
    }

    // create new ticket
    @PostMapping
    public CompletableFuture<ResponseEntity<Ticket>> create(@RequestBody Ticket t) {
        return service.createTicket(t)
                .thenApply(ResponseEntity::ok);
    }

    // update existing ticket
    @PutMapping("/{ticket_id}")
    public CompletableFuture<ResponseEntity<Ticket>> update(@PathVariable("ticket_id") Long id, @RequestBody Ticket t) {
        return service.updateTicket(id, t)
                .thenApply(ticket -> ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build());
    }

    // delete ticket
    @DeleteMapping("/{ticket_id}")
    public CompletableFuture<ResponseEntity<Void>> delete(@PathVariable("ticket_id") Long id) {
        return service.deleteTicket(id)
                .thenApply(v -> ResponseEntity.noContent().build());
    }
}
