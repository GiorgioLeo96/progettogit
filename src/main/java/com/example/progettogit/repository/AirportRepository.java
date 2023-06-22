package com.example.progettogit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettogit.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{
    
}
