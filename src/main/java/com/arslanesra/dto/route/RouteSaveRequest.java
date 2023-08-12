package com.arslanesra.dto.route;

import com.arslanesra.entity.Airport;
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
public class RouteSaveRequest {
    @NotBlank
    @Size(min = 5, max = 150)
    private String departureLocation;
    @NotBlank
    @Size(min = 5, max = 150)
    private String arrivalLocation;

}
