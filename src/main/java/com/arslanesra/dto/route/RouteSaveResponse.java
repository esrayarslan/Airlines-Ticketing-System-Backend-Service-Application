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
public class RouteSaveResponse {
    private Long id;
    private String departureLocation;
    private String arrivalLocation;

}
