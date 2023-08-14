package com.arslanesra.service;

import com.arslanesra.entity.Flight;
import com.arslanesra.entity.Passenger;
import com.arslanesra.util.CreditCardUtil;
import com.arslanesra.dto.ticket.TicketPurchaseRequest;
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
    private final FlightService flightService;
    private final PassengerService passengerService;
    public List<Ticket> findTicketsByNumber(String ticketNumber) {
        return ticketRepository.findByTicketNumber(ticketNumber);
    }
    private static TicketSaveResponse getTicketSaveResponse(Ticket savedTicket) {
        String departureName = savedTicket.getFlight().getRoute().getDepartureAirport().getName();
        String arrivalName = savedTicket.getFlight().getRoute().getArrivalAirport().getName();
        return TicketSaveResponse
                .builder()
                .id(savedTicket.getId())
                .departureAirport(departureName)
                .arrivalAirport(arrivalName)
                .ticketNumber(savedTicket.getTicketNumber())
                .passengerName(savedTicket.getPassengerName())
                .build();
    }
    public TicketSaveResponse update(TicketUpdateRequest ticketUpdateRequest) {
        var optionalTicket = ticketRepository.findById(ticketUpdateRequest.getId());
        if (optionalTicket.isPresent()) {
            var ticket = optionalTicket.get();
            ticket.setId(ticketUpdateRequest.getId());
            ticket.setTicketNumber(ticketUpdateRequest.getTicketNumber());
            ticket.setPassengerName(ticketUpdateRequest.getPassengerName());
            ticket = ticketRepository.save(ticket);
            return TicketSaveResponse
                    .builder()
                    .id(ticket.getId())
                    .ticketNumber(ticket.getTicketNumber())
                    .passengerName(ticket.getPassengerName())
                    .build();
        }
        throw new RuntimeException("Ticket not found");
    }
    public TicketSaveResponse purchaseTicket(TicketPurchaseRequest request) {
        String maskedCardNumber = CreditCardUtil.maskCreditCardNumber(request.getCardNumber());
        Long flightId = request.getFlightId();
        Flight flight = flightService.getFlight(flightId);
        Passenger passenger = passengerService.getPassenger(request.getPassengerSaveRequest());
        Ticket ticket = Ticket.builder()
                .cardNumber(maskedCardNumber)
                .passengerName(passenger.getFirstName() + " " + passenger.getLastName())
                .flight(flight)
                .build();
        return getTicketSaveResponse(ticketRepository.save(ticket));
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
