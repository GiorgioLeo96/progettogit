package com.example.progettogit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettogit.model.Booking;
import com.example.progettogit.model.Flight;
import com.example.progettogit.repository.FlightRepository;


@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportService airportService;
    
    public List<Flight> getAllFlight() {

        return flightRepository.findAll(); 
    }

    public Flight getFlightByID(Long id) {

        Optional<Flight> flightOpt = flightRepository.findById(id);

        return flightOpt.get();
    }

    public Flight createFlight(Flight flight) {

        
        if(flight.getArrAirport() != null){
            airportService.createAirport(flight.getArrAirport()); 
        }

        if(flight.getDepAirport()!= null){
            airportService.createAirport(flight.getDepAirport()); 
        }

        return flightRepository.save(flight);

    }

    
    public Flight updateFlight(Flight newFlight) {

        Flight oldFlight = getFlightByID(newFlight.getId());

        if (oldFlight != null) {

            oldFlight.setArrAirport(newFlight.getArrAirport());
            oldFlight.setDepAirport(newFlight.getDepAirport());
            oldFlight.setTimeArr(newFlight.getTimeArr());
            oldFlight.setTimeDep(newFlight.getTimeDep());

            
            return flightRepository.save(oldFlight);
        } else
            return null;
    }

    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);

    }
}
