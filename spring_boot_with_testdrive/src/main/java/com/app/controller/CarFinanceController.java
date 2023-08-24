//package com.app.controller;
//
//public class CarFinanceController {
//
//}


package com.app.controller;

import com.app.dto.CarFinanceDto;
import com.app.service.CarFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car-finances")
public class CarFinanceController {

    private final CarFinanceService carFinanceService;

    @Autowired
    public CarFinanceController(CarFinanceService carFinanceService) {
        this.carFinanceService = carFinanceService;
    }

    @PostMapping
    public ResponseEntity<CarFinanceDto> createCarFinance(@RequestBody CarFinanceDto carFinanceDto) {
        CarFinanceDto createdCarFinance = carFinanceService.createCarFinance(carFinanceDto);
        return new ResponseEntity<>(createdCarFinance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarFinanceDto>> getAllCarFinances() {
        List<CarFinanceDto> carFinances = carFinanceService.getAllCarFinances();
        return new ResponseEntity<>(carFinances, HttpStatus.OK);
    }

    @GetMapping("/{financeId}")
    public ResponseEntity<CarFinanceDto> getCarFinanceById(@PathVariable Long financeId) {
        CarFinanceDto carFinance = carFinanceService.getCarFinanceById(financeId);
        if (carFinance != null) {
            return new ResponseEntity<>(carFinance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{financeId}")
    public ResponseEntity<CarFinanceDto> updateCarFinance(
            @PathVariable Long financeId,
            @RequestBody CarFinanceDto carFinanceDto
    ) {
        CarFinanceDto updatedCarFinance = carFinanceService.updateCarFinance(financeId, carFinanceDto);
        if (updatedCarFinance != null) {
            return new ResponseEntity<>(updatedCarFinance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{financeId}")
    public ResponseEntity<Void> deleteCarFinance(@PathVariable Long financeId) {
        carFinanceService.deleteCarFinance(financeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
