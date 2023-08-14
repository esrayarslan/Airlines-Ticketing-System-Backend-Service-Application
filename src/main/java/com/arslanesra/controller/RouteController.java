package com.arslanesra.controller;

import com.arslanesra.api.BaseResponse;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.entity.Flight;
import com.arslanesra.entity.Route;
import com.arslanesra.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteSaveResponse> createRoute(@Valid @RequestBody RouteSaveRequest routeSaveRequest) {
        var response = routeService.save(routeSaveRequest);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public List<RouteSaveResponse> getAllRoutes() {
        return routeService.getAllRoutes();
    }
    @GetMapping("/search")
    public ResponseEntity<List<Route>> searchRoutesByDepartureAirport(@RequestParam String keyword) {
        List<Route> routes = routeService.searchRoutesByDepartureAirport(keyword);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }
    @GetMapping("/routes")
    public ResponseEntity<BaseResponse> getRoute() {
        List<RouteSaveResponse> routes = routeService.getAllRoutes();

        BaseResponse response = new BaseResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(routes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}