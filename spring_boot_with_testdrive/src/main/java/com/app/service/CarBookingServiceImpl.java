package com.app.service;

import com.app.dto.CarBookingDTO;
import com.app.dto.CarBookingUpdateDTO;
import com.app.entity.Cars;
import com.app.entity.CarBooking;
import com.app.entity.CarFinance;
import com.app.entity.CarInsurance;
import com.app.entity.Users;
import com.app.repository.CarBookingRepository;
import com.app.repository.CarFinanceRepository;
import com.app.repository.CarInsuranceRepository;
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

@Service
public class CarBookingServiceImpl implements CarBookingService {

    @Autowired
    private CarBookingRepository carBookingRepository;
    
    @Autowired
    private CarInsuranceRepository carInsuranceRepository;

    @Autowired
    private CarsRepository carRepository;

    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
    private CarFinanceRepository carFinanceRepository;

    @Override
    public CarBooking addBooking(CarBookingDTO bookingDTO) {
        Optional<Cars> carOptional = carRepository.findById(bookingDTO.getCarId());
        Optional<Users> userOptional = userRepository.findById(bookingDTO.getUserId());
        Optional<CarFinance> finanOptional = carFinanceRepository.findById(bookingDTO.getFinanceId());
        //Optional<CarInsurance> insuranceOptional =carInsuranceRepository.findById(bookingDTO.getInsuranceId());

        if (carOptional.isPresent() && userOptional.isPresent()) {
            CarBooking booking = new CarBooking();
            booking.setBookingDate(LocalDate.now());
            booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            booking.setCar(carOptional.get());
            booking.setUser(userOptional.get());
            booking.setFinance(finanOptional.get());
//            booking.setCarInsurance(insuranceOptional.get());
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

    @Override
    public CarBooking updateBooking(Long bookingId, CarBookingUpdateDTO bookingDTO) {
        Optional<CarBooking> bookingOptional = carBookingRepository.findById(bookingId); 
        if(bookingOptional != null)
        {
        	CarBooking booking = bookingOptional.get();
        	booking.setDeliveryDate(Date.from(bookingDTO.getDeliveryDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        	return carBookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        carBookingRepository.deleteById(bookingId);
    }

    @Override
    public CarBooking getBookingById(Long bookingId) {
        return carBookingRepository.findById(bookingId).orElse(null);
    }
}
