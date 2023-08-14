package com.arslanesra.service;

import com.arslanesra.util.CreditCardUtil;
import com.arslanesra.dto.ticket.TicketPurchaseRequest;
import com.arslanesra.dto.ticket.TicketSaveRequest;
import com.arslanesra.dto.ticket.TicketSaveResponse;
import com.arslanesra.dto.ticket.TicketUpdateRequest;
import com.arslanesra.entity.Ticket;
import com.arslanesra.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    public List<Ticket> findTicketsByNumber(String ticketNumber) {
        return ticketRepository.findByTicketNumber(ticketNumber);
    }
    public TicketSaveResponse save(TicketSaveRequest ticketSaveRequest){
        var newTicket = Ticket
                .builder()
                //.flight(ticketSaveRequest.getFlight())
                .ticketNumber(ticketSaveRequest.getTicketNumber())
                .passengerName(ticketSaveRequest.getPassengerName())
                .build();
        Ticket savedTicket = ticketRepository.save(newTicket);
        return TicketSaveResponse
                .builder()
                .id(savedTicket.getId())
                .ticketNumber(savedTicket.getTicketNumber())
                .flight(savedTicket.getFlight())
                .passengerName(savedTicket.getPassengerName())
                .build();
    }
    public TicketSaveResponse update(TicketUpdateRequest ticketUpdateRequest) {
        var optionalTicket = ticketRepository.findById(ticketUpdateRequest.getId());
        if (optionalTicket.isPresent()) {
            var ticket = optionalTicket.get();
            ticket.setId(ticketUpdateRequest.getId());
            ticket.setTicketNumber(ticketUpdateRequest.getTicketNumber());
            ticket.setFlight(ticketUpdateRequest.getFlight());
            ticket.setPassengerName(ticketUpdateRequest.getPassengerName());
            ticket = ticketRepository.save(ticket);
            return TicketSaveResponse
                    .builder()
                    .id(ticket.getId())
                    .ticketNumber(ticket.getTicketNumber())
                    .flight(ticket.getFlight())
                    .passengerName(ticket.getPassengerName())
                    .build();
        }
        throw new RuntimeException("Ticket not found");
    }
    public Ticket purchaseTicket(TicketPurchaseRequest request) {
        String maskedCardNumber = CreditCardUtil.maskCreditCardNumber(request.getCardNumber());

        Ticket ticket = new Ticket();
        ticket.setTicketNumber(request.getTicketNumber());
        ticket.setFlight(request.getFlight());
        ticket.setPassengerName(request.getPassengerName());
        ticket.setMaskedCardNumber(maskedCardNumber);

        return ticketRepository.save(ticket);
    }
    public Ticket cancelTicket(Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setCancelled(true);
            ticket.setDeleted(true);
            return ticketRepository.save(ticket);
        }
        throw new RuntimeException("Ticket not found");
    }
    public List<Ticket> getActiveTickets() {
        return ticketRepository.findByDeletedFalse();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
