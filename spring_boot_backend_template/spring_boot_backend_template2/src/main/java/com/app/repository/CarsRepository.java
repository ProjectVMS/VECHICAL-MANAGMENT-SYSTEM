package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}
