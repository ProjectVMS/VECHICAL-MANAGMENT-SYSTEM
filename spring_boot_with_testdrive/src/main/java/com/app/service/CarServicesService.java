
package com.app.service;

import java.util.List;

import com.app.entity.CarServices;

public interface CarServicesService {
	
	//get the services by carId
	CarServices getServicesById(Long carId);
	
	//get all carServices
	List<CarServices> getServices();

	
	

}
