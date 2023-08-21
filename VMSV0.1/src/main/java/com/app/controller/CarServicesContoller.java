package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.entity.CarServices;
import com.app.service.CarServicesService;

@RestController
@RequestMapping("/carServices")
@CrossOrigin(origins = "http://localhost:3000")
public class CarServicesContoller {

	@Autowired
	private CarServicesService carService;
	
	@GetMapping
	public List<CarServices> getAllServices(){
		
		return carService.getServices();
	}
	
	
}
