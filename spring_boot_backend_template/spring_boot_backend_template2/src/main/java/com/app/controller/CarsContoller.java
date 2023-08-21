package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entity.Cars;
import com.app.service.CarsService;

@RestController
@RequestMapping("/cars")
public class CarsContoller {
	
	@Autowired
	private CarsService carService;
	
	@GetMapping
	public List<Cars> listAllCars() {
		
		return carService.getAllCars();
	}
	
	
	@DeleteMapping("/{carId}")
	public String deleteCarFromId(@PathVariable Long carId) {
		return carService.deleteCar(carId);
	}
	
	@PostMapping
	public Cars saveCars(@RequestBody Cars car) {
		return carService.addCars(car);
	}
	
	@PutMapping("/{carId}")
	public Cars updateCars(@PathVariable Long carId, @RequestBody Cars updateCar) {
		Cars car = carService.getCarDetails(carId);
	
		if(car!= null) {
			car.setBrandName(updateCar.getBrandName());
			car.setDescription(updateCar.getDescription());
			car.setFuelType(updateCar.getFuelType());
			car.setMileage(updateCar.getMileage());
			car.setModelName(updateCar.getModelName());
			car.setPrice(updateCar.getPrice());
			car.setTransmissionType(updateCar.getTransmissionType());
			car.setYear(updateCar.getYear());
			
			carService.addCars(car);
			return car;
		}
		else {
			throw new ResourceNotFoundException("car Not Found..");
			
		}
	
	}

}
