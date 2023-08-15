package com.arslanesra.controller;

import com.arslanesra.base.BaseResponse;
import com.arslanesra.dto.airport.AirportSaveRequest;
import com.arslanesra.dto.airport.AirportSaveResponse;
import com.arslanesra.dto.airport.AirportUpdateRequest;
import com.arslanesra.entity.Airport;
import com.arslanesra.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airports")
public class AirportController {
    private final AirportService airportService;


    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }
    @GetMapping("/search")
    public List<Airport> searchAirports(@RequestParam String keyword) {
        return airportService.searchAirportsByName(keyword);
    }
    @PostMapping
    public ResponseEntity<BaseResponse<AirportSaveResponse>> createAirport(@Valid @RequestBody AirportSaveRequest request){
        var airportSaveResponse = airportService.save(request);
        var response =  BaseResponse.<AirportSaveResponse>builder()
                .status(HttpStatus.CREATED.value())
                .isSuccess(true)
                .data(airportSaveResponse)
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<AirportSaveResponse> updateAirport(@RequestBody AirportUpdateRequest airportUpdateRequest){
        return ResponseEntity.ok(airportService.update(airportUpdateRequest));
    }


}
