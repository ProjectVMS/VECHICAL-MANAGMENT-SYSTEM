package com.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarsDto {
	private String BrandName;
	private String ModelName;
	private String fuelType;
	private String description;
	
	private List<CarServiceDTO> carServices;

}
