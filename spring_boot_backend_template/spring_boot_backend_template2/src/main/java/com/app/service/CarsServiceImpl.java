package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entity.Cars;
import com.app.repository.CarsRepository;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {
	
	@Autowired
	private CarsRepository carRepo;

	@Override
	public List<Cars> getAllCars() {
		
		return carRepo.findAll();
	}
	
	@Override
	public Cars getCarDetails(Long carId) {

		return carRepo.findById(carId).orElseThrow(() -> new ResourceNotFoundException("No Such Car Found"));
	}

	@Override
	public String deleteCar(Long carId) {
	
		Cars car = getCarDetails(carId);
		
		carRepo.delete(car);
		
		return "car Deleted Sucessfully having id = " + carId;
	}

	@Override
	public Cars addCars(Cars car) {
		
		return carRepo.save(car);
	}



	

}
