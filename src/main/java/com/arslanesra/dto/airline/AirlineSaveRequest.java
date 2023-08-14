package com.arslanesra.dto.airline;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineSaveRequest {

    @NotBlank
    @Size(min = 5, max = 150)
    private String name;
    private String airplane;

}
