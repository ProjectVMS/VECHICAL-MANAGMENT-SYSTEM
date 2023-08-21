package com.app.service;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.CarServiceDTO;
import com.app.entity.CarService;
import com.app.entity.Cars;
import com.app.repository.CarServiceRepository;
import com.app.repository.CarsRepository;
import com.app.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceServiceImpl implements CarServiceService {

    private final CarServiceRepository carServiceRepository;
    private final CarsRepository carsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceServiceImpl(CarServiceRepository carServiceRepository, CarsRepository carsRepository,
                                 ModelMapper modelMapper) {
        this.carServiceRepository = carServiceRepository;
        this.carsRepository = carsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarServiceDTO> getAllCarServices() {
        List<CarService> carServices = carServiceRepository.findAll();
        return carServices.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarServiceDTO getCarServiceById(Long id) {
        CarService carService = carServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car Service not found with id: " + id));
        return convertToDto(carService);
    }

    @Override
    public CarServiceDTO createCarService(CarServiceDTO carServiceDTO) {
        CarService carService = convertToEntity(carServiceDTO);
        carService.setSelectedCar(carsRepository.findById(carServiceDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + carServiceDTO.getId())));
        CarService savedCarService = carServiceRepository.save(carService);
        return convertToDto(savedCarService);
    }
//    @Override
//    public CarServiceDTO createCarService(CarServiceDTO carServiceDTO) {
//        Cars selectedCar = carsRepository.findById(carServiceDTO.getCarId())
//            .orElseThrow(() -> new ResourceNotFoundException("Car not found"));
//
//        CarService carService = modelMapper.map(carServiceDTO, CarService.class);
//        carService.setSelectedCar(selectedCar);
//
//        CarService savedCarService = carServiceRepository.save(carService);
//
//        return modelMapper.map(savedCarService, CarServiceDTO.class);
//    }

    @Override
    public CarServiceDTO updateCarService(Long id, CarServiceDTO carServiceDTO) {
        CarService existingCarService = carServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car Service not found with id: " + id));
        modelMapper.map(carServiceDTO, existingCarService);
        existingCarService.setSelectedCar(carsRepository.findById(carServiceDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + carServiceDTO.getId())));
        CarService updatedCarService = carServiceRepository.save(existingCarService);
        return convertToDto(updatedCarService);
    }

    @Override
    public void deleteCarService(Long id) {
        CarService carService = carServiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car Service not found with id: " + id));
        carServiceRepository.delete(carService);
    }

    private CarServiceDTO convertToDto(CarService carService) {
        return modelMapper.map(carService, CarServiceDTO.class);
    }

    private CarService convertToEntity(CarServiceDTO carServiceDTO) {
        return modelMapper.map(carServiceDTO, CarService.class);
    }
}
