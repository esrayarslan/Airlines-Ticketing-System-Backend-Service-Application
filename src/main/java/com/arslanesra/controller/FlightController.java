package com.arslanesra.controller;

import com.arslanesra.api.BaseResponse;
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
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights();
    }
    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String keyword) {
        return flightService.searchFlightsByDeparture(keyword);
    }
    @GetMapping("/flights")
    public ResponseEntity<BaseResponse> getFlight() {
        List<Flight> flights = flightService.getAllFlights();

        BaseResponse response = new BaseResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(flights);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightSaveResponse> createFlight(@Valid @RequestBody FlightSaveRequest flightSaveRequest) {
        var response = flightService.save(flightSaveRequest);
        return ResponseEntity.ok(response);

    }

    @PutMapping
    public ResponseEntity<FlightSaveResponse> updateFlight(@RequestBody FlightUpdateRequest flightUpdateRequest){
        return ResponseEntity.ok(flightService.update(flightUpdateRequest));
    }


}
