package com.app.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "cars")
	public class Cars extends BaseEntity {
		@Column(name = "brand_name", length = 50)
	    private String brandName;
		@Column(name = "model_name", length = 50)
	    private String modelName;
	    private int year;
	    private double price;
	    private double mileage;
	    @Column(name = "fuel_type", length = 50)
	    private String fuelType;
	    @Column(name = "transmission_type", length = 50)
	    private String transmissionType;
	    @Column(length = 150)
	    private String description;

//	    @OneToMany(mappedBy = "cars",cascade=CascadeType.ALL,orphanRemoval = true)
//	    private List<CarService> service = new ArrayList<CarService>();
	   // @JsonIgnoreProperties("car")
//	    @OneToMany(mappedBy = "selectedCar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	    @JsonIgnoreProperties(value = "selectedCar")
//	    private List<CarService> carServices = new ArrayList<CarService>();
//	    
//	    @OneToOne(mappedBy = "carId", cascade = CascadeType.ALL, orphanRemoval = true)
//	    @JsonIgnoreProperties(value = "carId")
//	    private CarSpecification carSpecification;
//	    
//	    @OneToMany(mappedBy = "selectedCar", cascade = CascadeType.ALL, orphanRemoval = true)
//	    private List<CarService> carServices = new ArrayList<>();

	    
		@Override
		public String toString() {
			return "Cars [ id()=" + getId() + ", brandName= " + brandName + ", modelName=" + modelName + ", year=" + year + ", price=" + price
					+ ", mileage=" + mileage + ", fuelType=" + fuelType + ", transmissionType=" + transmissionType
					+ ", description=" + description +  "]";
		}
	    
	    
    
}
	

