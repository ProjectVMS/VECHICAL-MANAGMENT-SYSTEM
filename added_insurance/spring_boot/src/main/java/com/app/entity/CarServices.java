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
	
	@Column(name = "booking_date")
	private LocalDate serviceDate;
	
	@Column(name="service_name", length = 50)
	private String serviceName;
	
	@Column(length = 250)
	private String description;
	
	
//	@ManyToOne
//	@JoinColumn(name = "car_id")
//	private Cars selectedCar;

	
	@JsonIgnoreProperties("service")
// 	@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;
	


		

}
