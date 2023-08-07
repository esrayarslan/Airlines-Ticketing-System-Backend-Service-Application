package com.arslanesra.service;

import com.arslanesra.entity.Airport;
import com.arslanesra.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private final AirportRepository airportRepository;
    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
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