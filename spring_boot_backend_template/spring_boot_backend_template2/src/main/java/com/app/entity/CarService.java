package com.app.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="car_service")
public class CarService {
	@Id
	@GeneratedValue
	@Column(name="serv_id")
	private Long serviceId;
	@Column(name = "serv_date")
	private LocalDate serviceDate;
	@Column(name = "serv_desc", length = 90)
	private String Description;
	@ManyToOne
	@JoinColumn(name="car_id")
	private Cars selectedCar;
	

}




