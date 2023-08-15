package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.ticket.TicketPurchaseRequest;
import com.arslanesra.dto.ticket.TicketSaveResponse;
import com.arslanesra.dto.ticket.TicketUpdateRequest;
import com.arslanesra.entity.Ticket;
import com.arslanesra.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<TicketSaveResponse>> searchTicketsByNumber(@RequestParam String ticketNumber) {
        TicketSaveResponse ticket = ticketService.findTicketByNumber(ticketNumber);
        BaseResponse<TicketSaveResponse> response = BaseResponse.<TicketSaveResponse>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(ticket)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/active")
    public List<Ticket> getActiveTickets() {
        return ticketService.getActiveTickets();
    }
    @PostMapping("/purchase")
    public TicketSaveResponse purchaseTicket(@RequestBody TicketPurchaseRequest request) {
        return ticketService.purchaseTicket(request);
    }
    @PutMapping
    public ResponseEntity<TicketSaveResponse> updateTicket(@RequestBody TicketUpdateRequest ticketUpdateRequest){
        return ResponseEntity.ok(ticketService.update(ticketUpdateRequest));
    }
    @GetMapping
    public ResponseEntity<List<TicketSaveResponse>> getAllTickets() {

        var tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }
    @DeleteMapping
    public void cancelTicket(@RequestParam String ticketNumber)  {
        ticketService.cancelTicket(ticketNumber);
    }

}