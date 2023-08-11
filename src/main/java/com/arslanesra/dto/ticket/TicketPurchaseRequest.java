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
public class TicketPurchaseRequest {
    private Long id;
    private Flight flight;
    private String ticketNumber;
    private String passengerName;
    private String cardNumber;
    private String maskedCardNumber;


}
