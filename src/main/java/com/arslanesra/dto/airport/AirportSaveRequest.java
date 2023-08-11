package com.arslanesra.dto.airport;

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
public class AirportSaveRequest {
    private String code;
    @NotBlank
    @Size(min = 5, max = 150)
    private String name;
    @NotBlank
    @Size(min = 5, max = 25)
    private String city;
}
