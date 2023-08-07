package com.arslanesra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "airport_code", nullable = false, length = 50)
    private String code;
    @Column(name = "airport_name", nullable = false, length = 200)
    private String name;

    @Column(name = "airport_city", nullable = false, length = 100)
    private String city;
}
