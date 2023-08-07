package com.arslanesra.service;

import com.arslanesra.entity.Airline;
import com.arslanesra.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    private final AirlineRepository airlineRepository;
    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> getAllAirline() {
        return airlineRepository.findAll();
    }

    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public List<Airline> searchAirline(String keyword) {
        return airlineRepository.findByNameContaining(keyword);
    }
}

