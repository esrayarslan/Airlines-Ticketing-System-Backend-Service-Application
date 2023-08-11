package com.arslanesra.service;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.dto.airline.AirlineUpdateRequest;
import com.arslanesra.dto.airport.AirportSaveRequest;
import com.arslanesra.dto.airport.AirportSaveResponse;
import com.arslanesra.dto.airport.AirportUpdateRequest;
import com.arslanesra.entity.Airline;
import com.arslanesra.entity.Airport;
import com.arslanesra.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportSaveResponse save(AirportSaveRequest airportSaveRequest){
        var newAirport = Airport
                .builder()
                .code(airportSaveRequest.getCode())
                .name(airportSaveRequest.getName())
                .city(airportSaveRequest.getCity())
                .build();
        Airport savedAirport = airportRepository.save(newAirport);
        return AirportSaveResponse
                .builder()
                .code(savedAirport.getCode())
                .name(savedAirport.getName())
                .city(savedAirport.getCity())
                .build();
    }

    public AirportSaveResponse update(AirportUpdateRequest airportUpdateRequest) {
        var optionalAirport = airportRepository.findById(airportUpdateRequest.getId());
        if (optionalAirport.isPresent()) {
            var airport = optionalAirport.get();
            airport.setId(airportUpdateRequest.getId());
            airport.setName(airportUpdateRequest.getName());
            airport.setCode(airportUpdateRequest.getCode());
            airport.setCity(airportUpdateRequest.getCity());
            airport = airportRepository.save(airport);
            return AirportSaveResponse
                    .builder()
                    .id(airport.getId())
                    .name(airport.getName())
                    .code(airport.getCode())
                    .city(airport.getCity())
                    .build();
        }
        throw new RuntimeException("Airport not found");

    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public List<Airport> searchAirportsByName(String keyword) {
        return airportRepository.findByNameContaining(keyword);
    }
}