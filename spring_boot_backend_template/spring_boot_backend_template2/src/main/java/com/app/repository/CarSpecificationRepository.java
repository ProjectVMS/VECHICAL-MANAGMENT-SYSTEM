package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.CarSpecification;

@Repository
public interface CarSpecificationRepository extends JpaRepository<CarSpecification, Long> {
    
}
