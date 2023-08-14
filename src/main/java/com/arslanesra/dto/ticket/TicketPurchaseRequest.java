package com.arslanesra.dto.ticket;

import com.arslanesra.dto.passenger.PassengerSaveRequest;
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
    private Long flightId;
    private PassengerSaveRequest passengerSaveRequest;
    private String cardNumber;



}
