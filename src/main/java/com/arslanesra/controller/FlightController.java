package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.airport.AirportSaveRequest;
import com.arslanesra.dto.airport.AirportSaveResponse;
import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.flight.FlightUpdateRequest;
import com.arslanesra.entity.Flight;
import com.arslanesra.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;


    @GetMapping
    public ResponseEntity<List<FlightSaveResponse>> getAllFlights() {

        var flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlightsByDepartureAirport(@RequestParam String keyword) {
        List<Flight> flights = flightService.searchFlightsByDepartureAirport(keyword);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @PostMapping("/flight")
    public ResponseEntity<Object> createFlight(@Valid @RequestBody FlightSaveRequest request) {
        var flightSaveResponse = flightService.save(request);
        var response =  BaseResponse.<FlightSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(flightSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<FlightSaveResponse> updateFlight(@RequestBody FlightUpdateRequest flightUpdateRequest){
        return ResponseEntity.ok(flightService.update(flightUpdateRequest));
    }


}
