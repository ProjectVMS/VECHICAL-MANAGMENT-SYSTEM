package com.app.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Cars")
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
	    
	    
	    @LazyCollection(LazyCollectionOption.FALSE)
	    @JsonIgnoreProperties("car")
	    @OneToMany(mappedBy = "car")
	    private List<CarBooking> booking = new ArrayList<CarBooking>();
	    
	    
	    @OneToOne(mappedBy = "carId", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonIgnoreProperties(value = "carId")
	    private CarsSpecification carSpecification;
	    
	    
	    public void addBooking(CarBooking book) {
	    	booking.add(book);
	    	book.setCar(this);
	    }
	   
	    
	   
	    
		@Override
		public String toString() {
			return "Cars [ id()=" + getId() + ", brandName= " + brandName + ", modelName=" + modelName + ", year=" + year + ", price=" + price
					+ ", mileage=" + mileage + ", fuelType=" + fuelType + ", transmissionType=" + transmissionType
					+ ", description=" + description +  "]";
		}
	    
	    
    
}
	

