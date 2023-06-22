package com.example.progettogit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettogit.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    
}
