package com.app.service;

import java.util.List;

import com.app.entity.CarBooking;
import com.app.entity.Cars;

public interface BookingServicemain {
		//Get All Booking 
		List<CarBooking> getAllBooking();
		
		//Get Bookings Details From bookId;
		CarBooking getBookingDetails(Long bookiId);
		
		//Delete The Booking From bookId
		String deleteCBooking(Long bookiId);
		
		//Add The Booking 
		CarBooking addBooking (CarBooking book);

}
