package com.arslanesra.service;

import com.arslanesra.entity.Passenger;
import com.arslanesra.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;


    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> searchPassengersByFirstName(String keyword) {
        return passengerRepository.findByFirstNameContaining(keyword);
    }
}