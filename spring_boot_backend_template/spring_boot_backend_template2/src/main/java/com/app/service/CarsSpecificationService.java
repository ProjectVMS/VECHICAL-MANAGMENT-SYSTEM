//package com.app.service;
//
//import java.util.List;
//
//import com.app.entity.CarsSpecification;
//
//public interface NewCarSpecService {
//	List<CarsSpecification> getAllCarsSpec();
//    CarsSpecification getCarSpecification(Long specid);
//    CarsSpecification addCarsSpec(CarsSpecification carsspec);
//    String deleteCarSpec(Long specid);
//    CarsSpecification updateCarSpec(Long specid, CarsSpecification updatedSpec);
//
//}


package com.app.service;

import com.app.entity.CarsSpecification;

import java.util.List;

public interface CarsSpecificationService {
    CarsSpecification createCarsSpecification(CarsSpecification carsSpecification);
    CarsSpecification getCarSpecificationById(Long id);
    List<CarsSpecification> getAllCarSpecifications();
    CarsSpecification updateCarsSpecification(Long id, CarsSpecification carsSpecification);
    void deleteCarSpecification(Long id);
}

