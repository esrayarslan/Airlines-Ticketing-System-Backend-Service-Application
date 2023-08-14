package com.arslanesra.dto.flight;

import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveResponse {
    private Long id;
    private String departureAirportName;
    private String arrivalAirportName;
    private String airlineName;
    private Double price;
    private LocalDateTime flightDateTime;

}
