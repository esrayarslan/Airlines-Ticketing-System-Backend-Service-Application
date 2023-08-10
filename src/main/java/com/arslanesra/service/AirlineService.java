package com.arslanesra.service;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.entity.Airline;
import com.arslanesra.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineSaveResponse save(AirlineSaveRequest airlineSaveRequest){
        var newAirline = Airline
                .builder()
                .name(airlineSaveRequest.getName())
                .build();
        Airline savedAirline = airlineRepository.save(newAirline);
        return AirlineSaveResponse
                .builder()
                .name(savedAirline.getName())
                .build();
    }

    public List<Airline> getAllAirline() {

        return airlineRepository.findAll();
    }

    public Airline createAirline(AirlineSaveRequest request) {

        Airline airline = new Airline();
        airline.setName(request.getName());
        return airlineRepository.save(airline);
    }

    public List<Airline> searchAirline(String keyword) {
        return airlineRepository.findByNameContaining(keyword);
    }
}

