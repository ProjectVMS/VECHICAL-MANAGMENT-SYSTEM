package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dto.CarServiceDTO;
import com.app.entity.CarService;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
    // You can add custom query methods here if needed
//	CarServiceDTO createCarService(CarServiceDTO carServiceDTO);
}
