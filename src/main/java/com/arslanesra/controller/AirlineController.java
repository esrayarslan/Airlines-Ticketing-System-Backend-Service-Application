package com.arslanesra.controller;

import com.arslanesra.entity.Airline;
import com.arslanesra.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airlines")
public class AirlineController {
    private final AirlineService airlineService;

    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirline();
    }
    @PostMapping
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.createAirline(airline);
    }

    @GetMapping("/search")
    public List<Airline> searchAirline(@RequestParam String keyword) {
        return airlineService.searchAirline(keyword);
    }
}
