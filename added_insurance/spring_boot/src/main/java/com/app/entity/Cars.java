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
	    
//	    @OneToMany(mappedBy = "selectedCar", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
//	    @JsonIgnoreProperties(value = "selectedCar")
//	    private List<CarServices> carServices = new ArrayList<CarServices>();
	    
	    @LazyCollection(LazyCollectionOption.FALSE)
	    @JsonIgnoreProperties("car")
	   // @OneToMany(mappedBy = "car" , cascade = CascadeType.ALL, orphanRemoval = true)
	    @OneToMany(mappedBy = "car", orphanRemoval = true)
	    private List<CarBooking> booking = new ArrayList<CarBooking>();
	    
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
	

