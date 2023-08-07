package com.arslanesra.repository;

import com.arslanesra.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    List<Airline> findByNameContaining(String keyword);
}
