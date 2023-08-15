package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.entity.Airline;
import com.arslanesra.exception.BadRequestException;
import com.arslanesra.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airlines")
public class AirlineController {
    private final AirlineService airlineService;

    @GetMapping
    public ResponseEntity<List<Airline>> getAirlines() {

        var airlines = airlineService.getAllAirlines();
        return ResponseEntity.ok(airlines);
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<AirlineSaveResponse>>> searchAirline(@RequestParam("name") String keyword) {
        List<Airline> airlines = airlineService.getAllAirlinesByName(keyword);

        List<AirlineSaveResponse> airlineSaveResponses = airlines.stream()
                .map(airline -> AirlineSaveResponse.builder()
                        .id(airline.getId())
                        .name(airline.getName())
                        .build())
                .collect(Collectors.toList());

        BaseResponse<List<AirlineSaveResponse>> response = BaseResponse.<List<AirlineSaveResponse>>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(airlineSaveResponses)
                .build();

        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<Object> createAirline(@RequestBody AirlineSaveRequest request) throws BadRequestException {
        var airlineSaveResponse = airlineService.save(request);
        var response =  BaseResponse.<AirlineSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(airlineSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }





}
