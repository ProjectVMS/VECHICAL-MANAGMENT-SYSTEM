package com.app.entity;


import javax.persistence.*;

@MappedSuperclass 
public class BaseEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id",nullable=false)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getCarsId() {
//		return carsId;
//	}
//
//	public void setCarsId(Long carsId) {
//		this.carsId = carsId;
//	}

	
	

}
