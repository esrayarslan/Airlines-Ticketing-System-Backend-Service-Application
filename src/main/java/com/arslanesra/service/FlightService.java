package com.arslanesra.service;

import com.arslanesra.entity.Flight;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.FlightRepository;
import com.arslanesra.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, RouteRepository routeRepository) {
        this.flightRepository = flightRepository;
        this.routeRepository = routeRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight createFlight(Flight flight, Long routeId) {
        Route route = routeRepository.getById(routeId);
        flight.setRoute(route);
        return flightRepository.save(flight);
    }

    public List<Flight> searchFlightsByDeparture(String keyword) {
        return flightRepository.findByDepartureAirportContaining(keyword);
    }
}
