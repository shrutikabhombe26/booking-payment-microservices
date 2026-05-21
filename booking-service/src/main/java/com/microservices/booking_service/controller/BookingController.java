package com.microservices.booking_service.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.booking_service.entity.Booking;
import com.microservices.booking_service.services.BookingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/getBooking/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        Optional<Booking> bookingOptional = Optional.ofNullable(bookingService.getBookingById(id));
        if(bookingOptional.isPresent()) {
            return bookingOptional.get();
        } else {
            throw new RuntimeException("Booking not found with id: " +id);
        }
    }
}
