package com.arslanesra.service;

import com.arslanesra.dto.airport.AirportSaveRequest;
import com.arslanesra.dto.airport.AirportSaveResponse;
import com.arslanesra.dto.airport.AirportUpdateRequest;
import com.arslanesra.entity.Airport;
import com.arslanesra.exception.BadRequestException;
import com.arslanesra.repository.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    public AirportSaveResponse save(AirportSaveRequest airportSaveRequest) {
            var newAirport = Airport
                    .builder()
                    .code(airportSaveRequest.getCode())
                    .name(airportSaveRequest.getName())
                    .city(airportSaveRequest.getCity())
                    .build();
            Airport savedAirport = airportRepository.save(newAirport);
            return getAirportSaveResponse(savedAirport);
    }
    private static AirportSaveResponse getAirportSaveResponse(Airport savedAirport) {
        return AirportSaveResponse
                .builder()
                .id(savedAirport.getId())
                .code(savedAirport.getCode())
                .name(savedAirport.getName())
                .city(savedAirport.getCity())
                .build();
    }
    public AirportSaveResponse update(AirportUpdateRequest airportUpdateRequest) {
        var airport = airportRepository.findById(airportUpdateRequest.getId()).orElseThrow();//exc
        String airportUpdateRequestName = airportUpdateRequest.getName();
        airport.setName(airportUpdateRequestName);
        Airport updatedAirport = airportRepository.save(airport);
        return getAirportSaveResponse(updatedAirport);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
    public List<Airport> searchAirportsByName(String keyword) {
        return airportRepository.findByNameContaining(keyword);
    }

    public Airport getAirport(Long airportId) {
        return airportRepository.findById(airportId).orElseThrow(); //exp
    }
}