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

import com.example.progettogit.model.Airport;
import com.example.progettogit.service.AirportService;

@RestController
@RequestMapping("/api/airport")
public class AirportRestController {
    

    @Autowired
    private AirportService airportService;

    @GetMapping("/all")
    public ResponseEntity<List<Airport>> getAllAirports() {

        List<Airport> airports = airportService.getAllAirport();

        return new ResponseEntity<List<Airport>>(airports, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {

        return new ResponseEntity<Airport>(airportService.createAirport(airport), HttpStatus.OK);

    }

}
