package com.app.service;

import com.app.dto.CarsDTO;
import com.app.entity.Cars;

import java.util.List;

public interface CarsService {
    Cars addCar(CarsDTO carsDTO);
    void deleteCar(Long carId);
    Cars updateCar(Long carId, CarsDTO carsDTO);
    List<Cars> findAllCars();
    Cars findCarById(Long carId);
    List<Cars> findCarsByBookingId(Long bookingId);
    Cars findCarByName(String brandName);
    Cars findCarByModel(String modelName);
}
