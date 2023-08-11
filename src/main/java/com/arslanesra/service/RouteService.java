package com.arslanesra.service;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.dto.airline.AirlineUpdateRequest;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.dto.route.RouteUpdateRequest;
import com.arslanesra.entity.Airline;
import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.AirportRepository;
import com.arslanesra.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final AirportRepository airportRepository;

    public RouteSaveResponse save(RouteSaveRequest routeSaveRequest){
        var newRoute = Route
                .builder()
                .departureAirport(routeSaveRequest.getDepartureAirport())
                .arrivalAirport(routeSaveRequest.getArrivalAirport())
                .toAirport(routeSaveRequest.getToAirport())
                .build();
        Route savedRoute = routeRepository.save(newRoute);
        return RouteSaveResponse
                .builder()
                .departureAirport(savedRoute.getDepartureAirport())
                .arrivalAirport(savedRoute.getArrivalAirport())
                .toAirport(savedRoute.getToAirport())
                .build();
    }

    public RouteSaveResponse update(RouteUpdateRequest routeUpdateRequest) {
        var optionalRoute = routeRepository.findById(routeUpdateRequest.getId());
        if (optionalRoute.isPresent()) {
            var route = optionalRoute.get();
            route.setId(routeUpdateRequest.getId());
            route.setDepartureAirport(routeUpdateRequest.getDepartureAirport());
            route.setArrivalAirport(routeUpdateRequest.getArrivalAirport());
            route.setToAirport(routeUpdateRequest.getToAirport());
            route = routeRepository.save(route);
            return RouteSaveResponse
                    .builder()
                    .id(route.getId())
                    .build();
        }
        throw new RuntimeException("Route not found");

    }


    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route createRoute(Route route, Long fromAirportId, Long toAirportId) {
        Airport fromAirport = airportRepository.getById(fromAirportId);
        Airport toAirport = airportRepository.getById(toAirportId);
        route.setToAirport(fromAirport);
        route.setToAirport(toAirport);
        return routeRepository.save(route);
    }

    public List<Route> searchRoutesByOrigin(String keyword) {
        return routeRepository.findByDepartureAirportContaining(keyword);
    }
}
