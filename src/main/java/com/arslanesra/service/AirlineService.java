package com.arslanesra.service;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.dto.airline.AirlineSaveResponse;
import com.arslanesra.entity.Airline;
import com.arslanesra.repository.AirlineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional

public class AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineSaveResponse save(AirlineSaveRequest airlineSaveRequest){
        var newAirline = Airline
                .builder()
                .name(airlineSaveRequest.getName())
                .airplane(airlineSaveRequest.getAirplane())
                .build();
        Airline savedAirline = airlineRepository.save(newAirline);
        return AirlineSaveResponse
                .builder()
                .id(savedAirline.getId())
                .name(savedAirline.getName())
                .airplane(savedAirline.getAirplane())
                .build();
    }
    public List<Airline> getAllAirlines() {

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

    public Airline getAirline(Long airlineId) {
        return airlineRepository.findById(airlineId).orElseThrow();//airline company
    }
}

