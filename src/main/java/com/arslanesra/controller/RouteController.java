package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.route.RouteSaveRequest;
import com.arslanesra.dto.route.RouteSaveResponse;
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

    @PostMapping
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
    public ResponseEntity<BaseResponse<RouteSaveResponse>> searchRouteById(@RequestParam Long routeId) {
        RouteSaveResponse route = routeService.searchRouteById(routeId);
        BaseResponse<RouteSaveResponse> response = BaseResponse.<RouteSaveResponse>builder()
                .status(HttpStatus.OK.value())
                .isSuccess(true)
                .data(route)
                .build();
        return ResponseEntity.ok(response);
    }






}