package com.arslanesra.repository;

import com.arslanesra.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByRouteDepartureAirportNameContainingIgnoreCase(String keyword);
}
