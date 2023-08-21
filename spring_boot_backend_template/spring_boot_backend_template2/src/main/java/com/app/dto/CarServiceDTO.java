package com.app.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CarServiceDTO {
	private Long id;
	private LocalDate serviceDate;
	private String Description;
	

}
