package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.flight.FlightSaveRequest;
import com.arslanesra.dto.flight.FlightSaveResponse;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.entity.Route;
import com.arslanesra.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    @PostMapping("/route")
    public ResponseEntity<Object> createRoute(@Valid @RequestBody RouteSaveRequest request) {
        var routeSaveResponse = routeService.save(request);
        var response =  BaseResponse.<RouteSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(routeSaveResponse)
                .build();
        return ok(response);
    }
    @GetMapping
    public List<RouteSaveResponse> getAllRoutes() {
        return routeService.getAllRoutes();
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse<Route>> searchRouteById(@RequestParam Long routeId) {
        Route route = routeService.searchRouteById(routeId);
        BaseResponse<Route> response = BaseResponse.<Route>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(route)
                .build();

        return ResponseEntity.ok(response);
    }






}