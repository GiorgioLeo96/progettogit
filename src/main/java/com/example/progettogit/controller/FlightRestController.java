package com.example.progettogit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.progettogit.model.Flight;
import com.example.progettogit.service.FlightService;

@RestController
@RequestMapping("/api/Flight")
public class FlightRestController {
    

    @Autowired
    private FlightService flightService;

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights() {

        List<Flight> flights = flightService.getAllFlight();

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {

        return new ResponseEntity<Flight>(flightService.createFlight(flight), HttpStatus.OK);

    }
    

}
