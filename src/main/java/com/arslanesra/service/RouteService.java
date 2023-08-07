package com.arslanesra.service;

import com.arslanesra.entity.Airport;
import com.arslanesra.entity.Route;
import com.arslanesra.repository.AirportRepository;
import com.arslanesra.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final AirportRepository airportRepository;


    @Autowired
    public RouteService(RouteRepository routeRepository, AirportRepository airportRepository) {
        this.routeRepository = routeRepository;
        this.airportRepository = airportRepository;
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
