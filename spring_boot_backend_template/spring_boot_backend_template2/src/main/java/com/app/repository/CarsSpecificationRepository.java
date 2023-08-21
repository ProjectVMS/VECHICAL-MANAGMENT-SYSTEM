//package com.app.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//import com.app.entity.CarsSpecification;
//
//public interface CarsSpeciRepository extends JpaRepository<CarsSpecification, Long>{
//
//}

//
package com.app.repository;

import com.app.entity.CarsSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsSpecificationRepository extends JpaRepository<CarsSpecification, Long> {
    // You can add custom query methods here if needed
}

