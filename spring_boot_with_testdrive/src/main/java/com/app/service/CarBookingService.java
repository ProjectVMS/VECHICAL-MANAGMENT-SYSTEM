package com.app.service;

import com.app.dto.CarBookingDTO;
import com.app.dto.CarBookingUpdateDTO;
import com.app.entity.CarBooking;

import java.util.List;

public interface CarBookingService {
    CarBooking addBooking(CarBookingDTO bookingDTO);
    List<CarBooking> getBookingsByUserId(Long userId);
    List<CarBooking> getBookingsByCarId(Long carId);
    List<CarBooking> getAllBookings();
    CarBooking updateBooking(Long bookingId, CarBookingUpdateDTO bookingDTO);
    void deleteBooking(Long bookingId);
    CarBooking getBookingById(Long bookingId);
}
