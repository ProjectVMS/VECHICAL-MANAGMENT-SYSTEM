package com.app.repository;

import com.app.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    Optional<Cars> findByBrandName(String brandName);
    Optional<Cars> findByModelName (String modelName);
    
}
