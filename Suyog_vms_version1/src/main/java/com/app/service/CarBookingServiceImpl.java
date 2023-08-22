package com.app.service;

import com.app.dto.CarBookingDTO;
import com.app.entity.Cars;
import com.app.entity.CarBooking;
import com.app.entity.Users;
import com.app.repository.CarBookingRepository;
import com.app.repository.CarsRepository;
import com.app.repository.UsersRepository;
import com.app.service.CarBookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
@Service
public class CarBookingServiceImpl implements CarBookingService {

    @Autowired
    private CarBookingRepository carBookingRepository;

    @Autowired
    private CarsRepository carRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public CarBooking addBooking(CarBookingDTO bookingDTO) {
        Optional<Cars> carOptional = carRepository.findById(bookingDTO.getCarId());
        Optional<Users> userOptional = userRepository.findById(bookingDTO.getUserId());

        if (carOptional.isPresent() && userOptional.isPresent()) {
            CarBooking booking = new CarBooking();
            booking.setBookingDate(LocalDate.now());
            booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            booking.setCar(carOptional.get());
            booking.setUser(userOptional.get());
            return carBookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public List<CarBooking> getBookingsByUserId(Long userId) {
        return carBookingRepository.findByUserId(userId);
    }

    @Override
    public List<CarBooking> getBookingsByCarId(Long carId) {
        return carBookingRepository.findByCarId(carId);
    }

    @Override
    public List<CarBooking> getAllBookings() {
        return carBookingRepository.findAll();
    }
    
    @Transactional
    @Override
    public CarBooking updateBooking(Long bookingId, CarBookingDTO bookingDTO) {
        Optional<CarBooking> bookingOptional = carBookingRepository.findById(bookingId);
        if (bookingOptional.isPresent()) {
            CarBooking booking = bookingOptional.get();
            booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            return carBookingRepository.saveAndFlush(booking);
        }
        return null;
    }

//    
//    @Override
//    public CarBooking updateBooking(Long bookingId, CarBookingDTO bookingDTO) {
//        Optional<CarBooking> bookingOptional = carBookingRepository.findById(bookingId);
//        if (bookingOptional.isPresent()) {
//            CarBooking booking = bookingOptional.get();
//            booking.setDeliveryDate(bookingDTO.getDeliveryDate());
//            CarBooking updatedBooking = carBookingRepository.save(booking);
//            entityManager.flush(); // Explicitly flush changes to the database
//            return updatedBooking;
//        }
//        return null;
//    }
    
//    @Override
//    public CarBooking updateBooking(Long bookingId, CarBookingDTO bookingDTO) {
//        Optional<CarBooking> bookingOptional = carBookingRepository.findById(bookingId);
//        if (bookingOptional.isPresent()) {
//            CarBooking booking = bookingOptional.get();
//            booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            
//            // Save and flush the changes within a transaction
//            CarBooking updatedBooking = carBookingRepository.saveAndFlush(booking);
//
//            return updatedBooking;
//        }
//        return null;
//    }

    
    
    @Override
    public void deleteBooking(Long bookingId) {
        carBookingRepository.deleteById(bookingId);
    }

    @Override
    public CarBooking getBookingById(Long bookingId) {
        return carBookingRepository.findById(bookingId).orElse(null);
    }
}
