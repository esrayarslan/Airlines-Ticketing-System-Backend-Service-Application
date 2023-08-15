package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.airport.AirportSaveRequest;
import com.arslanesra.dto.airport.AirportSaveResponse;
import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.passenger.PassengerSaveRequest;
import com.arslanesra.dto.passenger.PassengerSaveResponse;
import com.arslanesra.dto.passenger.PassengerUpdateRequest;
import com.arslanesra.entity.Passenger;
import com.arslanesra.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

   /* @PostMapping("/passenger")
    public ResponseEntity<Object> createPassenger(@Valid @RequestBody PassengerSaveRequest request) {
        var passengerSaveResponse = passengerService.save(request);
        var response =  BaseResponse.<AirportSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(passengerSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }*/

    @PutMapping
    public ResponseEntity<PassengerSaveResponse> updatePassenger(@RequestBody PassengerUpdateRequest passengerUpdateRequest){
        return ResponseEntity.ok(passengerService.update(passengerUpdateRequest));
    }


}