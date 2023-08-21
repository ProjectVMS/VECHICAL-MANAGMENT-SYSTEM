package com.app.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.entity.CarServices;
import com.app.repository.CarServicesRepository;

@Service
@Transactional
public class CarServicesServiceImpl implements CarServicesService{
	@Autowired
	private CarServicesRepository carSerRepo;

	@Override
	public CarServices getServicesById(Long carId) {
		
		return carSerRepo.findById(carId).orElseThrow(() -> new ResourceNotFoundException("Car Not Found in CarServices "));
	}

	@Override
	public List<CarServices> getServices() {
		
		return carSerRepo.findAll();
	}
	



}
