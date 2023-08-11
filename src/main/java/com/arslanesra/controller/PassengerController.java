package com.arslanesra.controller;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.dto.airline.AirlineUpdateRequest;
import com.arslanesra.dto.passenger.PassengerSaveRequest;
import com.arslanesra.dto.passenger.PassengerSaveResponse;
import com.arslanesra.dto.passenger.PassengerUpdateRequest;
import com.arslanesra.entity.Passenger;
import com.arslanesra.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {

        return passengerService.getAllPassengers();
    }
    @GetMapping("/search")
    public List<Passenger> searchPassengers(@RequestParam String keyword) {
        return passengerService.searchPassengersByFirstName(keyword);
    }

    @PostMapping
    public ResponseEntity<PassengerSaveResponse> createPassenger(@Valid @RequestBody PassengerSaveRequest passengerSaveRequest) {
        var response = passengerService.save(passengerSaveRequest);
        return ResponseEntity.ok(response);

    }

    @PutMapping
    public ResponseEntity<PassengerSaveResponse> updatePassenger(@RequestBody PassengerUpdateRequest passengerUpdateRequest){
        return ResponseEntity.ok(passengerService.update(passengerUpdateRequest));
    }


}