package com.arslanesra.service;

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