package com.arslanesra.service;

import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.flight.FlightUpdateRequest;
import com.arslanesra.entity.Flight;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.FlightRepository;
import com.arslanesra.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final RouteRepository routeRepository;

    public FlightSaveResponse save(FlightSaveRequest flightSaveRequest){
        var newFlight = Flight
                .builder()
                .fromAirport(flightSaveRequest.getFromAirport())
                .toAirport(flightSaveRequest.getToAirport())
                .route(flightSaveRequest.getRoute())
                .build();
        Flight savedFlight = flightRepository.save(newFlight);
        return FlightSaveResponse
                .builder()
                .fromAirport(savedFlight.getFromAirport())
                .toAirport(savedFlight.getToAirport())
                .route(savedFlight.getRoute())
                .build();
    }

    public FlightSaveResponse update(FlightUpdateRequest flightUpdateRequest) {
        var optionalFlight = flightRepository.findById(flightUpdateRequest.getId());
        if (optionalFlight.isPresent()) {
            var flight = optionalFlight.get();
            flight.setId(flightUpdateRequest.getId());
            flight.setFromAirport(flightUpdateRequest.getFromAirport());
            flight.setToAirport(flightUpdateRequest.getToAirport());
            flight.setRoute(flightUpdateRequest.getRoute());
            flight = flightRepository.save(flight);
            return FlightSaveResponse
                    .builder()
                    .id(flight.getId())
                    .fromAirport(flight.getFromAirport())
                    .toAirport(flight.getToAirport())
                    .route(flight.getRoute())
                    .build();
        }
        throw new RuntimeException("Flight not found");
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
        return flightRepository.findByFromAirportContaining(keyword);
    }
}
