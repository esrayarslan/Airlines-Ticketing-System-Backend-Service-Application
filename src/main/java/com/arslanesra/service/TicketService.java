package com.arslanesra.service;

import com.arslanesra.CreditCardUtil;
import com.arslanesra.dto.ticket.TicketPurchaseRequest;
import com.arslanesra.dto.ticket.TicketSaveRequest;
import com.arslanesra.dto.ticket.TicketSaveResponse;
import com.arslanesra.dto.ticket.TicketUpdateRequest;
import com.arslanesra.entity.Ticket;
import com.arslanesra.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketSaveResponse save(TicketSaveRequest ticketSaveRequest){
        var newTicket = Ticket
                .builder()
                .flight(ticketSaveRequest.getFlight())
                .maskedCardNumber(ticketSaveRequest.getMaskedCardNumber())
                .passengerName(ticketSaveRequest.getPassengerName())
                .build();
        Ticket savedTicket = ticketRepository.save(newTicket);
        return TicketSaveResponse
                .builder()
                .id(savedTicket.getId())
                .flight(savedTicket.getFlight())
                .maskedCardNumber(savedTicket.getMaskedCardNumber())
                .passengerName(savedTicket.getPassengerName())
                .build();
    }

    public TicketSaveResponse update(TicketUpdateRequest ticketUpdateRequest) {
        var optionalTicket = ticketRepository.findById(ticketUpdateRequest.getId());
        if (optionalTicket.isPresent()) {
            var ticket = optionalTicket.get();
            ticket.setId(ticketUpdateRequest.getId());
            ticket.setFlight(ticketUpdateRequest.getFlight());
            ticket.setPassengerName(ticketUpdateRequest.getPassengerName());
            ticket.setMaskedCardNumber(ticketUpdateRequest.getMaskedCardNumber());
            ticket = ticketRepository.save(ticket);
            return TicketSaveResponse
                    .builder()
                    .id(ticket.getId())
                    .flight(ticket.getFlight())
                    .passengerName(ticket.getPassengerName())
                    .maskedCardNumber(ticket.getMaskedCardNumber())
                    .build();
        }
        throw new RuntimeException("Ticket not found");

    }

    public Ticket purchaseTicket(TicketPurchaseRequest request) {
        String maskedCardNumber = CreditCardUtil.maskCreditCardNumber(request.getCardNumber());

        Ticket ticket = new Ticket();
        ticket.setFlight(request.getFlight());
        ticket.setPassengerName(request.getPassengerName());
        ticket.setMaskedCardNumber(maskedCardNumber);

        return ticketRepository.save(ticket);
    }


}
