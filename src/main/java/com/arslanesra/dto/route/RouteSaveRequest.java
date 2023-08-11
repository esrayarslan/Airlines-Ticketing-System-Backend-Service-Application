package com.arslanesra.dto.route;

import com.arslanesra.entity.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteSaveRequest {
    private String departureAirport;
    private String arrivalAirport;
    private Airport toAirport;
}
