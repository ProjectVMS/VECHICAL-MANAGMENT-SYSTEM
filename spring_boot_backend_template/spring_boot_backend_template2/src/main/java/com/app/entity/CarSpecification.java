package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars_spec")
@EqualsAndHashCode
@ToString
public class CarSpecification {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="spec_id",nullable = false)
	private Long specificationId;
	@Column(name="car_color",length = 50)
	private String color;
	@Column(name="car_engine",length = 50)
	private String engine;
	private double horsepower;
	private double dimensions;
	
	@OneToOne
	@JoinColumn(name="car_id",nullable=false)
	private Cars carId;
	
	

	
}
