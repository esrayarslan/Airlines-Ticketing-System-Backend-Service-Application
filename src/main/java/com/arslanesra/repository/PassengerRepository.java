package com.arslanesra.repository;

import com.arslanesra.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByFirstNameContaining(String keyword);
}

