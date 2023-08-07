package com.arslanesra.repository;

import com.arslanesra.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByFirstNameContaining(String keyword);
}

