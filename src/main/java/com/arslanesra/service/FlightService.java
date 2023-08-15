package com.arslanesra.service;

import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.flight.FlightUpdateRequest;
import com.arslanesra.entity.Airline;
import com.arslanesra.entity.Flight;
import com.arslanesra.entity.Route;
import com.arslanesra.exception.NotFoundException;
import com.arslanesra.repository.FlightRepository;
import com.arslanesra.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final RouteService routeService;
    private final AirlineService airlineService;

    public FlightSaveResponse save(FlightSaveRequest flightSaveRequest) throws NotFoundException {
        Long airlineId = flightSaveRequest.getAirlineId();
        Airline airline = airlineService.getAirline(airlineId);
        Long routeId = flightSaveRequest.getRouteId();
        Route route = routeService.getRoute(routeId);
        var newFlight = Flight
                .builder()
                .route(route)
                .price(flightSaveRequest.getPrice())
                .flightDateTime(flightSaveRequest.getFlightDateTime())
                .airline(airline)
                .build();
        Flight savedFlight = flightRepository.save(newFlight);
        return getFlightSaveResponse(savedFlight);
    }
    public FlightSaveResponse update(FlightUpdateRequest flightUpdateRequest) {
        LocalDateTime flightDateTime = flightUpdateRequest.getFlightDateTime();
        Double price = flightUpdateRequest.getPrice();
        Flight flight = flightRepository.findById(flightUpdateRequest.getId()).orElseThrow(); //Exc supplier
        flight.setFlightDateTime(flightDateTime);
        flight.setPrice(price);
        Flight savedFlight = flightRepository.save(flight);
        return getFlightSaveResponse(savedFlight);
    }

    public List<FlightSaveResponse> getAllFlights() {
        return flightRepository.findAll().stream().map(flight -> getFlightSaveResponse(flight)).toList();
    }
    public List<FlightSaveResponse> searchFlightsByDepartureAirportName(String name) {
        List<Flight> flights = flightRepository.findAllByRouteDepartureAirportNameContainingIgnoreCase(name);
        return flights.stream().map(flight -> getFlightSaveResponse(flight)).toList();
    }

    private FlightSaveResponse getFlightSaveResponse(Flight savedFlight) {

        return FlightSaveResponse
                .builder()
                .airlineName(savedFlight.getAirline().getName())
                .departureAirportName(savedFlight.getRoute().getDepartureAirport().getName())
                .arrivalAirportName(savedFlight.getRoute().getArrivalAirport().getName())
                .flightDateTime(savedFlight.getFlightDateTime())
                .price(savedFlight.getPrice())
                .id(savedFlight.getId())
                .build();
    }

    public Flight getFlight(Long flightId) {
        return flightRepository.findById(flightId).orElseThrow();
    }
}
