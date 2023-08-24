package com.app.service;

import com.app.dto.CarFinanceDto;
import com.app.entity.CarFinance;
import com.app.entity.Users;
import com.app.repository.CarFinanceRepository;
import com.app.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarFinanceServiceImpl implements CarFinanceService {

	@Autowired
    private final CarFinanceRepository carFinanceRepository;
    
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    public CarFinanceServiceImpl(CarFinanceRepository carFinanceRepository) {
        this.carFinanceRepository = carFinanceRepository;
    }

    @Override
    public CarFinanceDto createCarFinance(CarFinanceDto carFinanceDTO) {

        CarFinance carFinance = new CarFinance();

        // Map fields from DTO to entity
        carFinance.setLoanAmount(carFinanceDTO.getLoanAmount());
        carFinance.setInterestRate(carFinanceDTO.getInterestRate());
        carFinance.setMonthlyPayment(carFinanceDTO.getMonthlyPayment());
        carFinance.setFinanceName(carFinanceDTO.getFinanceName());
        
        CarFinance savedCarFinance = carFinanceRepository.save(carFinance);
        return mapToDTO(savedCarFinance);
        
    }

    @Override
    public List<CarFinanceDto> getAllCarFinances() {
        List<CarFinance> carFinances = carFinanceRepository.findAll();
        List<CarFinanceDto> carFinanceDTOs = new ArrayList<>();

        for (CarFinance carFinance : carFinances) {
            carFinanceDTOs.add(mapToDTO(carFinance));
        }

        return carFinanceDTOs;
    }

    @Override
    public CarFinanceDto getCarFinanceById(Long financeId) {
        Optional<CarFinance> optionalCarFinance = carFinanceRepository.findById(financeId);
        return optionalCarFinance.map(this::mapToDTO).orElse(null);
    }

    @Override
    public CarFinanceDto updateCarFinance(Long financeId, CarFinanceDto carFinanceDTO) {
        Optional<CarFinance> optionalCarFinance = carFinanceRepository.findById(financeId);
        if (optionalCarFinance.isPresent()) {
            CarFinance carFinance = optionalCarFinance.get();
            // Update fields from DTO to entity
            carFinance.setLoanAmount(carFinanceDTO.getLoanAmount());
            carFinance.setInterestRate(carFinanceDTO.getInterestRate());
            carFinance.setMonthlyPayment(carFinanceDTO.getMonthlyPayment());
            carFinance.setFinanceName(carFinanceDTO.getFinanceName());

            CarFinance updatedCarFinance = carFinanceRepository.save(carFinance);
            return mapToDTO(updatedCarFinance);
        }
        return null;
    }

    @Override
    public void deleteCarFinance(Long financeId) {
        carFinanceRepository.deleteById(financeId);
    }

    private CarFinanceDto mapToDTO(CarFinance carFinance) {
        return new CarFinanceDto(
                
                carFinance.getLoanAmount(),
                carFinance.getInterestRate(),
                carFinance.getMonthlyPayment(),
                carFinance.getFinanceName()
        );
    }
}


