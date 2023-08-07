package com.arslanesra.repository;

import com.arslanesra.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    List<Airline> findByNameContaining(String keyword);
}
