package com.arslanesra.dto.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportSaveRequest {
    private String code;
    private String name;
    private String city;
}
