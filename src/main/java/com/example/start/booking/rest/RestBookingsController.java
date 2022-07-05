package com.example.start.booking.rest;

import com.example.start.booking.data.BookingRepository;
import com.example.start.booking.model.entities.Booking;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class RestBookingsController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/{date}")
    public List<Booking> getBookingsByDate(@PathVariable("date") String date) {
        Date sqlDate = Date.valueOf(date);
        return bookingRepository.findAllByDate(sqlDate);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingRepository.deleteById(id);
    }
    @GetMapping()
    public Booking getBooking(@RequestParam("id") Long id) {
        return bookingRepository.findById(id).get();
    }
    @PostMapping()
    public Booking newBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @PutMapping()
    public Booking updateBooking(@RequestBody Booking updatedBooking) {
        bookingRepository.save(updatedBooking);
        return updatedBooking;
    }
}
