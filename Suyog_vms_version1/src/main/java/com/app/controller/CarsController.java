package com.app.controller;

import com.app.dto.CarsDTO;
import com.app.entity.Cars;
import com.app.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping
    public ResponseEntity<Cars> addCar(@RequestBody CarsDTO carsDTO) {
        Cars addedCar = carsService.addCar(carsDTO);
        return ResponseEntity.ok(addedCar);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId) {
        carsService.deleteCar(carId);
        return ResponseEntity.ok("Car deleted successfully");
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Cars> updateCar(@PathVariable Long carId, @RequestBody CarsDTO carsDTO) {
        Cars updatedCar = carsService.updateCar(carId, carsDTO);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> cars = carsService.findAllCars();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Cars> getCarById(@PathVariable Long carId) {
        Cars car = carsService.findCarById(carId);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-booking/{bookingId}")
    public ResponseEntity<List<Cars>> getCarsByBookingId(@PathVariable Long bookingId) {
        List<Cars> cars = carsService.findCarsByBookingId(bookingId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/by-name/{brandName}")
    public ResponseEntity<Cars> getCarByName(@PathVariable String brandName) {
        Cars car = carsService.findCarByName(brandName);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/bookingByModel/{modelName}")
    public ResponseEntity<Cars> getCarByModel(@PathVariable String modelName){
    	 Cars car = carsService.findCarByModel(modelName);
         if (car != null) {
             return ResponseEntity.ok(car);
         } else {
             return ResponseEntity.notFound().build();
         }
    }
    
    
}
