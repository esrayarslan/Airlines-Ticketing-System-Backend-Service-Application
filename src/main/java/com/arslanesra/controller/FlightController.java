package com.arslanesra.controller;

import com.arslanesra.entity.Flight;
import com.arslanesra.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight, @RequestParam Long routeId) {
        return flightService.createFlight(flight, routeId);
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String keyword) {
        return flightService.searchFlightsByDeparture(keyword);
    }
}
