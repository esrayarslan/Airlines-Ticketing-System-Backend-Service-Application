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

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<Airline>> searchAirline(@RequestParam String keyword) {
        var airlines = airlineService.searchAirline(keyword);
        HttpHeaders headers = new HttpHeaders();
        headers.add("HEADER-AIRLINE", "Header value airline");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(airlines);
    }

    @PostMapping("/airline")
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
