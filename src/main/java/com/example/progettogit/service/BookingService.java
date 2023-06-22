package com.example.progettogit.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.progettogit.model.Booking;
import com.example.progettogit.repository.BookingRepository;


@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService; 

    public List<Booking> getAllBookings() {

        return bookingRepository.findAll(); 
    }


    public Booking getBookingByID(Long id) {

        Optional<Booking> bookingOpt = bookingRepository.findById(id);

        return bookingOpt.get();
    }

    public Booking createBooking(Booking booking) {

        
        if(booking.getFlight() != null){ 
           
            
            flightService.createFlight(booking.getFlight()); 
        }


        return bookingRepository.save(booking);

    }

    public Booking updateBooking(Booking newBooking) {

        Booking oldBooking = getBookingByID(newBooking.getId());

        if (oldBooking != null) {

            oldBooking.setCode(newBooking.getCode());
            oldBooking.setDescription(newBooking.getDescription());
            oldBooking.setSeatNumber(newBooking.getSeatNumber());
            oldBooking.setTicketPrice(newBooking.getTicketPrice());
            oldBooking.setFlight(newBooking.getFlight());

            return bookingRepository.save(oldBooking);
        } else
            return null; 
    }

    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);

    }
}
