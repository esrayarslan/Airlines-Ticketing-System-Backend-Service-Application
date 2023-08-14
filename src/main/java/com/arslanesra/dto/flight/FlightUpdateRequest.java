package com.arslanesra.dto.flight;

import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUpdateRequest {
    private Long id;
    private Double price;
    private LocalDateTime flightDateTime;
}
