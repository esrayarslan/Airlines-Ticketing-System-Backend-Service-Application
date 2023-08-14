package com.arslanesra.dto.flight;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveRequest {
    private Long routeId;
    private Long airlineId;
    private Double price;
    private LocalDateTime flightDateTime;

}
