package com.arslanesra.dto.flight;

import com.arslanesra.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUpdateRequest {
    private Long id;

    private String departureAirport;
    private String arrivalAirport;
    private Route route;
}
