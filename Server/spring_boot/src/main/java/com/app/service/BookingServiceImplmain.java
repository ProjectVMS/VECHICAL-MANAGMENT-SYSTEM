//package com.app.service;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.custom_exception.ResourceNotFoundException;
//import com.app.dto.CarBookingDto;
//import com.app.entity.CarBooking;
//import com.app.entity.Cars;
//import com.app.repository.BoookingRepository;
//@Service
//@Transactional
//public class BookingServiceImplmain implements BookingService {
//
//	@Autowired
//	private BoookingRepository bookrepo;
//	@Override
//	public List<CarBooking> getAllBooking() {
//	
//		return bookrepo.findAll();
//	}
//
//	@Override
//	public CarBooking getBookingDetails(Long bookiId) {
//
//		return bookrepo.findById(bookiId).orElseThrow(() -> new ResourceNotFoundException("No Such Booking Found"));
//	}
//
//	@Override
//	public String deleteCBooking(Long bookiId) {
//
//		CarBooking book = getBookingDetails(bookiId);
//		
//		bookrepo.delete(book);
//		
//		return "Booking Deleted SucessFully Having Id = "+bookiId;
//	}
//
//	@Override
//	public CarBooking addBooking(CarBooking book) {
//		
//		return bookrepo.save(book);
//	}
//
//
//}
