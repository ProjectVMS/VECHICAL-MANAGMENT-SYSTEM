package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="car_insurance")
public class CarInsurance {
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long insuranceId;


@Column(name = "insurance_provider", length = 50)
private String insuranceProvider;

@Column(name="policy_no")
private Long policyNumber;

@Column(name="premiun_amt")
private double premiumAmt;

@Column(name="claim_amt")
private double claimAmt;

private Long year;

//@OneToOne(mappedBy = "insurance")
////@JsonIgnoreProperties("insurances")
//private CarBooking booking;



//@ManyToOne
//@JoinColumn(name = "car_id") 
//private Cars selectedCar;

}

