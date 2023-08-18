package com.app.entity;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="car_services")
public class CarServices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="service_id")
	private Long serviceId;
	
	@Column(name = "service_date")
	private LocalDate serviceDate;
	@Column(length = 200)
	private String description;
	
	
//	@ManyToOne
//	@JoinColumn(name = "car_id")
//	private Cars selectedCar;



		

}
