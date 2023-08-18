package com.app.service;

import com.app.dto.CarsDTO;
import com.app.entity.Cars;
import com.app.repository.CarsRepository;
import com.app.service.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Cars addCar(CarsDTO carsDTO) {
        Cars car = convertToEntity(carsDTO);
        return carsRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carsRepository.deleteById(carId);
    }

    @Override
    public Cars updateCar(Long carId, CarsDTO carsDTO) {
        Optional<Cars> existingCarOptional = carsRepository.findById(carId);
        if (existingCarOptional.isPresent()) {
            Cars existingCar = existingCarOptional.get();
            Cars updatedCar = convertToEntity(carsDTO);
            updatedCar.setId(existingCar.getId());
            return carsRepository.save(updatedCar);
        }
        return null;
    }

    @Override
    public List<Cars> findAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public Cars findCarById(Long carId) {
        return carsRepository.findById(carId).orElse(null);
    }

    @Override
    public List<Cars> findCarsByBookingId(Long bookingId) {
        // Assuming each booking contains a list of car IDs
        return carsRepository.findAll().stream()
                .filter(car -> car.getBooking().stream().anyMatch(booking -> booking.getId().equals(bookingId)))
                .collect(Collectors.toList());
    }

    @Override
    public Cars findCarByName(String brandName) {
        return carsRepository.findByBrandName(brandName).orElse(null);
    }

    private Cars convertToEntity(CarsDTO carsDTO) {
        return modelMapper.map(carsDTO, Cars.class);
    }

    private CarsDTO convertToDTO(Cars car) {
        return modelMapper.map(car, CarsDTO.class);
    }
}
