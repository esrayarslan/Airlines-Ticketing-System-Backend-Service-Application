package com.arslanesra.dto.flight;

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
    private String departureAirport;
    @NotBlank
    @Size(min = 5, max = 150)
    private String arrivalAirport;
    private Route route;
}
