package com.arslanesra.repository;

import com.arslanesra.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByDepartureAirportContaining(String keyword);
}
