package com.example.progettogit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettogit.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
    
}
