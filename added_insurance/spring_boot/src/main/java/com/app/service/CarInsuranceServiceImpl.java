package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CarInsurance;
import com.app.repository.CarInsuranceRepository;

@Service
@Transactional
public class CarInsuranceServiceImpl implements CarInsuranceService {
	
	@Autowired
	private CarInsuranceRepository carInsuranceRepo;

	@Override
	public List<CarInsurance> getAllInsurance() {
		return carInsuranceRepo.findAll();
	}

}
