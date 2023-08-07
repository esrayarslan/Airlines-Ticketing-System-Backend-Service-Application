package com.arslanesra.service;

import com.arslanesra.dto.airline.AirlineSaveRequest;
import com.arslanesra.entity.Airline;
import com.arslanesra.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AirlineService {
    private final AirlineRepository airlineRepository;

    public Airline save(Airline airline){
        return airlineRepository.save(airline);
    }

    public List<Airline> getAllAirline() {

        return airlineRepository.findAll();
    }

    public Airline createAirline(AirlineSaveRequest request) {
        // AirlineSaveRequest nesnesini kullanarak yeni bir Airline oluştur
        Airline airline = new Airline();
        airline.setName(request.getName());
        // Diğer özellikleri de ayarlayabilirsiniz

        // Oluşturulan Airline nesnesini kaydet ve döndür
        return airlineRepository.save(airline);
    }

    public List<Airline> searchAirline(String keyword) {
        return airlineRepository.findByNameContaining(keyword);
    }
}

