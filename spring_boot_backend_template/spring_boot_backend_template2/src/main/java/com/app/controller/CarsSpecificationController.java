//package com.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.entity.CarsSpecification;
//import com.app.service.CarsSpeciService;
//import com.app.service.NewCarSpecService;
//
//@RequestMapping("/newcarsspec")
//@RestController
//public class NewCarSpecController {
//	
//
//    @Autowired
//    private NewCarSpecService carsspecservice;
//
//    @GetMapping
//    public List<CarsSpecification> listAllcarsspec() {
//        return carsspecservice.getAllCarsSpec();
//    }
//
//    @GetMapping("/{specid}")
//    public ResponseEntity<CarsSpecification> getCarById(@PathVariable Long specid) {
//        CarsSpecification carspec = carsspecservice.getCarSpecification(specid);
//        return carspec != null ? ResponseEntity.ok(carspec) : ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public CarsSpecification saveCarsSpec(@RequestBody CarsSpecification carsspec) {
//        return carsspecservice.addCarsSpec(carsspec);
//    }
//
//    @DeleteMapping("/{specid}")
//    public String deleteCarSpec(@PathVariable Long specid) {
//        return carsspecservice.deleteCarSpec(specid);
//    }
//
//    @PutMapping("/{specid}")
//    public ResponseEntity<CarsSpecification> updateCarSpec(@PathVariable Long specid, @RequestBody CarsSpecification updateSpec) {
//        CarsSpecification cs = carsspecservice.updateCarSpec(specid, updateSpec);
//        if (cs != null) {
//            return ResponseEntity.ok(cs);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // ... Other methods
//
//}


package com.app.controller;

import com.app.entity.CarsSpecification;
import com.app.service.CarsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars/specifications")
public class CarsSpecificationController {
    private final CarsSpecificationService specificationService;

    @Autowired
    public CarsSpecificationController(CarsSpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @PostMapping
    public ResponseEntity<CarsSpecification> createCarsSpecification(@RequestBody CarsSpecification carsSpecification) {
        CarsSpecification createdSpecification = specificationService.createCarsSpecification(carsSpecification);
        return new ResponseEntity<>(createdSpecification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarsSpecification> getCarSpecificationById(@PathVariable Long id) {
        CarsSpecification carSpecification = specificationService.getCarSpecificationById(id);
        return ResponseEntity.ok(carSpecification);
    }

    @GetMapping
    public ResponseEntity<List<CarsSpecification>> getAllCarSpecifications() {
        List<CarsSpecification> allSpecifications = specificationService.getAllCarSpecifications();
        return ResponseEntity.ok(allSpecifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarsSpecification> updateCarsSpecification(
            @PathVariable Long id, @RequestBody CarsSpecification updatedSpec) {
        CarsSpecification updatedSpecification = specificationService.updateCarsSpecification(id, updatedSpec);
        return ResponseEntity.ok(updatedSpecification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarSpecification(@PathVariable Long id) {
        specificationService.deleteCarSpecification(id);
        return ResponseEntity.noContent().build();
    }
}

