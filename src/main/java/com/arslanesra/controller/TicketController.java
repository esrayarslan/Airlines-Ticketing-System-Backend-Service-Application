package com.arslanesra.controller;

import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.dto.airline.AirlineUpdateRequest;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.dto.ticket.TicketPurchaseRequest;
import com.arslanesra.dto.ticket.TicketSaveRequest;
import com.arslanesra.dto.ticket.TicketSaveResponse;
import com.arslanesra.dto.ticket.TicketUpdateRequest;
import com.arslanesra.entity.Ticket;
import com.arslanesra.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;
    @PostMapping
    public ResponseEntity<TicketSaveResponse> createTicket(@Valid @RequestBody TicketSaveRequest ticketSaveRequest) {
        var response = ticketService.save(ticketSaveRequest);
        return ResponseEntity.ok(response);

    }
    @GetMapping("/search")
    public List<Ticket> searchTicketsByNumber(@RequestParam String ticketNumber) {
        return ticketService.findTicketsByNumber(ticketNumber);
    }
    @GetMapping("/active")
    public List<Ticket> getActiveTickets() {
        return ticketService.getActiveTickets();
    }
    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody TicketPurchaseRequest request) {
        return ticketService.purchaseTicket(request);
    }
    @PutMapping
    public ResponseEntity<TicketSaveResponse> updateTicket(@RequestBody TicketUpdateRequest ticketUpdateRequest){
        return ResponseEntity.ok(ticketService.update(ticketUpdateRequest));
    }
    @PostMapping("/{ticketId}/cancel")
    public Ticket cancelTicket(@PathVariable Long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}