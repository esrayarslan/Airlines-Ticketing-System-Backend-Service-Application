package com.arslanesra.controller;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.entity.Airline;
import com.arslanesra.service.AirlineService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airlines")
public class AirlineController {
    private final AirlineService airlineService;

    @GetMapping
    public ResponseEntity<List<Airline>> getAirlines() {

        var airlines = airlineService.getAllAirline();
        return ResponseEntity.ok(airlines);
    }
    @PostMapping
    public ResponseEntity<AirlineSaveResponse> createAirline(@RequestBody AirlineSaveRequest airlineSaveRequest) {
        var response = airlineService.save(airlineSaveRequest);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Airline>> searchAirline(@RequestParam String keyword) {
        var airlines = airlineService.searchAirline(keyword);
        HttpHeaders headers = new HttpHeaders();
        headers.add("HEADER-AIRLINE", "Header value airline");

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(airlines);

    }
}
