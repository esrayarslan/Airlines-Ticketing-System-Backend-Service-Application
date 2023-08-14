package com.arslanesra.controller;

import com.arslanesra.api.BaseResponse;
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
    @GetMapping("/airports")
    public ResponseEntity<BaseResponse> getAirport() {
        List<Airport> airports = airportService.getAllAirports();

        BaseResponse response = new BaseResponse();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(airports);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<AirportSaveResponse> createAirline(@Valid @RequestBody AirportSaveRequest airportSaveRequest) {
        var response = airportService.save(airportSaveRequest);
        return ResponseEntity.ok(response);

    }
    @PutMapping
    public ResponseEntity<AirportSaveResponse> updateAirport(@RequestBody AirportUpdateRequest airportUpdateRequest){
        return ResponseEntity.ok(airportService.update(airportUpdateRequest));
    }


}
