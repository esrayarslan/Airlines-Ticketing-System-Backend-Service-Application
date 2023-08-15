package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.flight.FlightUpdateRequest;
import com.arslanesra.exception.NotFoundException;
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
    public ResponseEntity<BaseResponse<List<FlightSaveResponse>>> getAllFlights() {
        List<FlightSaveResponse> flightSaveResponses = flightService.getAllFlights();
        BaseResponse<List<FlightSaveResponse>> response = BaseResponse.<List<FlightSaveResponse>>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(flightSaveResponses)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<FlightSaveResponse>>> searchFlightsByDepartureAirportName(@RequestParam ("name") String name) {
        List<FlightSaveResponse> flightSaveResponses = flightService.getAllFlights();
        BaseResponse<List<FlightSaveResponse>> response = BaseResponse.<List<FlightSaveResponse>>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(flightSaveResponses)
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Object> createFlight(@Valid @RequestBody FlightSaveRequest request) throws NotFoundException {
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
