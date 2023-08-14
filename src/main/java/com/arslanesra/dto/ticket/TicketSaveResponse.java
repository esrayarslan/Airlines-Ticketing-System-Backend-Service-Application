package com.arslanesra.dto.ticket;

import com.arslanesra.entity.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketSaveResponse {
    private Long id;
    private String departureAirport;
    private String arrivalAirport;
    private String ticketNumber;
    private String passengerName;

}
