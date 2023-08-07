package com.arslanesra.repository;

import com.arslanesra.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findByNameContaining(String keyword);
}
