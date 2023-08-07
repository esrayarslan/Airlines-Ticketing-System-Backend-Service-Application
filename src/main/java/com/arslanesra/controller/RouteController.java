package com.arslanesra.controller;

import com.arslanesra.entity.Route;
import com.arslanesra.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route, @RequestParam Long fromAirportId, @RequestParam Long toAirportId) {
        return routeService.createRoute(route, fromAirportId, toAirportId);
    }


    @GetMapping("/search")
    public List<Route> searchRoutes(@RequestParam String keyword) {
        return routeService.searchRoutesByOrigin(keyword);
    }
}