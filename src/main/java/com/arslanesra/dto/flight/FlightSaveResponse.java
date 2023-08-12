package com.arslanesra.dto.flight;

import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveResponse {
    private Long id;

    private Airport fromAirport;
    private Airport toAirport;
    private Route route;
}
