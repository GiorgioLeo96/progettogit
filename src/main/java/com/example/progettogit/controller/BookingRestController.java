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

import com.example.progettogit.model.Booking;
import com.example.progettogit.service.BookingService;


@RestController
@RequestMapping("/api/booking")
public class BookingRestController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {

        List<Booking> bookings = bookingService.getAllBookings();

        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.OK);

    }

}