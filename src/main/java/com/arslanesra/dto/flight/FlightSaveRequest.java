package com.arslanesra.dto.flight;

import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSaveRequest {
    @NotBlank
    @Size(min = 5, max = 150)
    private Airport fromAirport;
    @NotBlank
    @Size(min = 5, max = 150)
    private Airport toAirport;
    private Route route;
}
