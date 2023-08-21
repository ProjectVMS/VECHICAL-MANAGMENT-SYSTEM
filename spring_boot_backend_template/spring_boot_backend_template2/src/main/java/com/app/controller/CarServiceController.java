package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CarServiceDTO;
import com.app.service.CarServiceService;

import java.util.List;

@RestController
@RequestMapping("/car-services")
public class CarServiceController {

    private final CarServiceService carServiceService;

    @Autowired
    public CarServiceController(CarServiceService carServiceService) {
        this.carServiceService = carServiceService;
    }

    @GetMapping
    public ResponseEntity<List<CarServiceDTO>> getAllCarServices() {
        List<CarServiceDTO> carServices = carServiceService.getAllCarServices();
        return ResponseEntity.ok(carServices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarServiceDTO> getCarServiceById(@PathVariable Long id) {
        CarServiceDTO carService = carServiceService.getCarServiceById(id);
        return ResponseEntity.ok(carService);
    }

    @PostMapping
    public ResponseEntity<CarServiceDTO> createCarService(@RequestBody CarServiceDTO carServiceDTO) {
        CarServiceDTO createdCarService = carServiceService.createCarService(carServiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCarService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarServiceDTO> updateCarService(@PathVariable Long id,
                                                          @RequestBody CarServiceDTO carServiceDTO) {
        CarServiceDTO updatedCarService = carServiceService.updateCarService(id, carServiceDTO);
        return ResponseEntity.ok(updatedCarService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarService(@PathVariable Long id) {
        carServiceService.deleteCarService(id);
        return ResponseEntity.noContent().build();
    }
}
