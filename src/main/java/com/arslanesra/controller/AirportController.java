package com.arslanesra.controller;

import com.arslanesra.entity.Airport;
import com.arslanesra.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportService airportService;


    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @GetMapping("/search")
    public List<Airport> searchAirports(@RequestParam String keyword) {
        return airportService.searchAirportsByName(keyword);
    }
}
