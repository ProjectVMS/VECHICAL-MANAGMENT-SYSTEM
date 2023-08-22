//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.custom_exception.ResourceNotFoundException;
//import com.app.entity.CarBooking;
//import com.app.entity.Cars;
//import com.app.service.BookingService;
//
//@RestController
//@RequestMapping("/booking")
//public class BookingControllermain {
//
//	@Autowired
//	private BookingService bookService;
//	
//	@GetMapping
//	public List<CarBooking> getAllbooking(){
//		return bookService.getAllBooking();
//	}
//	
//	@DeleteMapping("/{bookId}")
//	public String deleteBookFromId(@PathVariable Long bookId) {
//		return bookService.deleteCBooking(bookId);
//	}
//	
//
//	@PostMapping
//	public CarBooking saveBooking (@RequestBody CarBooking book) {
//		return bookService.addBooking(book);
//	}
//	
//	
//	@PutMapping("/{bookId}")
//	public CarBooking updateBooking(@PathVariable Long bookId, @RequestBody CarBooking updateBoooking) {
//		CarBooking book = bookService.getBookingDetails(bookId);
//		
//		if(book!=null) {
//			book.setBookingDate(updateBoooking.getBookingDate());
//			book.setDeliveryDate(updateBoooking.getDeliveryDate());
//			book.setCar(updateBoooking.getCar());
//			bookService.addBooking(book);
//			return book;
//			
//		}
//		else 
//		{
//			throw new ResourceNotFoundException("Booking Not Found..");
//		}
//	}
//}
