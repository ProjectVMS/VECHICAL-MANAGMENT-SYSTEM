
package com.app.service;

import java.util.List;

import com.app.entity.Cars;

public interface CarsService {
	
	//Get All The Cars
	List<Cars> getAllCars();
	
	//Get Car Details From carId;
	Cars getCarDetails(Long carId);
	
	//Delete The Cars From CarId
	String deleteCar(Long carId);
	
	//Add The Cars
	Cars addCars(Cars car);

	
	

}
