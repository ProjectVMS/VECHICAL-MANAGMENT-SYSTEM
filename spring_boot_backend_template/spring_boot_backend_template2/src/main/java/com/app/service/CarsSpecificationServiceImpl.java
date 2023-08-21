//package com.app.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.app.entity.CarsSpecification;
//import com.app.repository.CarsSpeciRepository;
//@Service
//public class NewCarSpecServiceImpl implements NewCarSpecService {
//	
//	@Autowired
//    private CarsSpeciRepository carsSpecificationRepository;
//
//	 @Override
//	    public List<CarsSpecification> getAllCarsSpec() {
//	        return carsSpecificationRepository.findAll();
//	    }
//
//	    @Override
//	    public CarsSpecification getCarSpecification(Long specid) {
//	        return carsSpecificationRepository.findById(specid).orElse(null);
//	    }
//
//	    @Override
//	    public CarsSpecification addCarsSpec(CarsSpecification carsspec) {
//	        return carsSpecificationRepository.save(carsspec);
//	    }
//
//	    @Override
//	    public String deleteCarSpec(Long specid) {
//	        carsSpecificationRepository.deleteById(specid);
//	        return "Deleted car specification with ID: " + specid;
//	    }
//
//
//	    @Override
//	    public CarsSpecification updateCarSpec(Long specid, CarsSpecification updatedSpec) {
//	        CarsSpecification cs = carsSpecificationRepository.findById(specid).orElse(null);
//	        if (cs != null) {
//	            cs.setColor(updatedSpec.getColor());
//	            cs.setEngine(updatedSpec.getEngine());
//	            cs.setHorsepower(updatedSpec.getHorsepower());
//	            cs.setDimensions(updatedSpec.getDimensions());
//	            // Update other fields as needed
//	            return carsSpecificationRepository.save(cs);
//	        }
//	        return null;
//	    }
//
//}


package com.app.service;

import com.app.entity.CarsSpecification;
import com.app.repository.CarsSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsSpecificationServiceImpl implements CarsSpecificationService {
    private final CarsSpecificationRepository specificationRepository;

    @Autowired
    public CarsSpecificationServiceImpl(CarsSpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    @Override
    public CarsSpecification createCarsSpecification(CarsSpecification carsSpecification) {
        return specificationRepository.save(carsSpecification);
    }

    @Override
    public CarsSpecification getCarSpecificationById(Long id) {
        return specificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car specification not found with id: " + id));
    }

    @Override
    public List<CarsSpecification> getAllCarSpecifications() {
        return specificationRepository.findAll();
    }

    @Override
    public CarsSpecification updateCarsSpecification(Long id, CarsSpecification updatedSpec) {
        CarsSpecification existingSpec = getCarSpecificationById(id);
        existingSpec.setColor(updatedSpec.getColor());
        existingSpec.setEngine(updatedSpec.getEngine());
        existingSpec.setHorsepower(updatedSpec.getHorsepower());
        existingSpec.setDimensions(updatedSpec.getDimensions());
        return specificationRepository.save(existingSpec);
    }

    @Override
    public void deleteCarSpecification(Long id) {
        specificationRepository.deleteById(id);
    }
}

