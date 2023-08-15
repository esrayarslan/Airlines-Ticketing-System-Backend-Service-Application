package com.arslanesra.service;

import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final AirportService airportService;

    public RouteSaveResponse save(RouteSaveRequest routeSaveRequest){
        Long arrivalAirportId = routeSaveRequest.getArrivalAirportId();
        Long departureAirportId = routeSaveRequest.getDepartureAirportId();
        Airport departureAirport = airportService.getAirport(departureAirportId);
        Airport arrivalAirport = airportService.getAirport(arrivalAirportId);
        var newRoute = Route
                .builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .build();
        Route savedRoute = routeRepository.save(newRoute);
        return getRouteSaveResponse(savedRoute);
    }
    private RouteSaveResponse getRouteSaveResponse(Route savedRoute) {
        return RouteSaveResponse
                .builder()
                .id(savedRoute.getId())
                .departureAirport(savedRoute.getDepartureAirport().getName())
                .arrivalAirport(savedRoute.getArrivalAirport().getName())
                .build();
    }
    public List<RouteSaveResponse> getAllRoutes() {
        List<Route> routeList = routeRepository.findAll();
        return routeList.stream().map(route -> getRouteSaveResponse(route)).toList();
    }
    public Route getRoute(Long routeId) {
       return routeRepository.findById(routeId).orElseThrow(); // exception ekle
    }

    public RouteSaveResponse searchRouteById(Long routeId) {
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new NoSuchElementException("Route not found"));
        return getRouteSaveResponse(route);
    }
}
