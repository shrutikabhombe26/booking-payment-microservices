package com.microservices.booking_service.services;

import org.springframework.stereotype.Service;

import com.microservices.booking_service.entity.Booking;
import com.microservices.booking_service.repository.BookingInterface;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingInterface bookingRepository;

    public Booking createBooking(Booking booking) {
        Booking bookingResponse = bookingRepository.save(booking);
        return bookingResponse;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }
}
