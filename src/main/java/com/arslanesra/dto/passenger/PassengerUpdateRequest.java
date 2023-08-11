package com.arslanesra.dto.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerUpdateRequest {
    private Long id;
    private String firstName;
    private String lastName;
}
