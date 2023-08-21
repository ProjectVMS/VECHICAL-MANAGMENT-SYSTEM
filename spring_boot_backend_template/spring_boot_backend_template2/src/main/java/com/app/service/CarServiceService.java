package com.app.service;


	import java.util.List;

import com.app.dto.CarServiceDTO;

	public interface CarServiceService {
	    List<CarServiceDTO> getAllCarServices();
	    CarServiceDTO getCarServiceById(Long id);
	    CarServiceDTO createCarService(CarServiceDTO carServiceDTO);
	    CarServiceDTO updateCarService(Long id, CarServiceDTO carServiceDTO);
	    void deleteCarService(Long id);
	}


