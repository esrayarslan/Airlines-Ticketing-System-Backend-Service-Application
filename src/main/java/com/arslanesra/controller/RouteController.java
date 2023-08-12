package com.arslanesra.controller;

import com.arslanesra.api.BaseResponse;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
import com.arslanesra.dto.route.RouteUpdateRequest;
import com.arslanesra.entity.Passenger;
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

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
    @GetMapping("/search")
    public List<Route> searchRoutes(@RequestParam String keyword) {
        return routeService.searchRoutesByOrigin(keyword);
    }
    @GetMapping("/routes")
    public ResponseEntity<BaseResponse> getRoute() {
        List<Route> routes = routeService.getAllRoutes();

        BaseResponse response = new BaseResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(routes);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RouteSaveResponse> createRoute(@Valid @RequestBody RouteSaveRequest routeSaveRequest) {
        var response = routeService.save(routeSaveRequest);
        return ResponseEntity.ok(response);

    }

    @PutMapping
    public ResponseEntity<RouteSaveResponse> updateRoute(@RequestBody RouteUpdateRequest routeUpdateRequest){
        return ResponseEntity.ok(routeService.update(routeUpdateRequest));
    }



}