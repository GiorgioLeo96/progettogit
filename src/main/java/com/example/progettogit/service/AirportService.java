package com.example.progettogit.service;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettogit.model.Airport;

import com.example.progettogit.repository.AirportRepository;


@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    public List<Airport> getAllAirport() {

        return airportRepository.findAll(); 
    }

    
    public Airport getAirportByID(Long id) {

        
        Optional<Airport> airportOpt = airportRepository.findById(id); 

        return airportOpt.get(); 

    }

    public Airport createAirport(Airport airport) {

        return airportRepository.save(airport);

    }

    public Airport updateAirport(Airport newAirport) {

        Airport oldAirport = getAirportByID(newAirport.getId());

        if (oldAirport != null) {

            oldAirport.setCity(newAirport.getCity());
            oldAirport.setCode(newAirport.getCode());
            oldAirport.setName(newAirport.getName());
            oldAirport.setNation(newAirport.getNation());

            
            return airportRepository.save(oldAirport);
        } else
            return null; 
    }

    public void deleteAirport(Long id) {

        airportRepository.deleteById(id);

    }
}

