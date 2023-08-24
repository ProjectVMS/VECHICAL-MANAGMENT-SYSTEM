package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CarInsurance;
import com.app.service.CarInsuranceService;

@RestController
@RequestMapping("/insurance")
@CrossOrigin(origins = "http://localhost:3000")
public class CarInsuranceController {
	
	@Autowired
	private CarInsuranceService insuranceService;
	
	@GetMapping
    public List<CarInsurance> getInsurance(){
		return insuranceService.getAllInsurance();
	}

}
