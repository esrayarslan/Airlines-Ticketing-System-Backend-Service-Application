package com.arslanesra.service;

import com.arslanesra.dto.passenger.PassengerSaveRequest;
import com.arslanesra.dto.passenger.PassengerSaveResponse;
import com.arslanesra.dto.passenger.PassengerUpdateRequest;
import com.arslanesra.entity.Passenger;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerSaveResponse save(PassengerSaveRequest passengerSaveRequest){
        var newPassenger = Passenger
                .builder()
                .firstName(passengerSaveRequest.getFirstName())
                .lastName(passengerSaveRequest.getLastName())
                .build();
        Passenger savedPassenger = passengerRepository.save(newPassenger);
        return PassengerSaveResponse
                .builder()
                .firstName(savedPassenger.getFirstName())
                .lastName(savedPassenger.getLastName())
                .build();
    }

    public PassengerSaveResponse update(PassengerUpdateRequest passengerUpdateRequest) {
        var optionalPassenger = passengerRepository.findById(passengerUpdateRequest.getId());
        if (optionalPassenger.isPresent()) {
            var passenger = optionalPassenger.get();
            passenger.setId(passengerUpdateRequest.getId());
            passenger.setFirstName(passengerUpdateRequest.getFirstName());
            passenger.setLastName(passengerUpdateRequest.getLastName());
            passenger = passengerRepository.save(passenger);
            return PassengerSaveResponse
                    .builder()
                    .id(passenger.getId())
                    .firstName(passenger.getFirstName())
                    .lastName(passenger.getLastName())
                    .build();
        }
        throw new RuntimeException("Passenger not found");
    }


    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public List<Passenger> searchPassengersByFirstName(String keyword) {
        return passengerRepository.findByFirstNameContaining(keyword);
    }

    public Passenger getPassenger(PassengerSaveRequest passengerSaveRequest) {
        Passenger passenger = Passenger.builder()
                .firstName(passengerSaveRequest.getFirstName())
                .lastName(passengerSaveRequest.getLastName())
                .build();
        return passengerRepository.save(passenger);
    }
}

