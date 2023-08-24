//package com.app.service;
//
//import java.util.List;
//
//import com.app.entity.CarFinance;
//
//public interface CarFinanceService {
//	List<CarFinance> getAllCarFinance();
//	
//	void deleteCarFinance(Long financeId);
//}


package com.app.service;

import com.app.dto.CarFinanceDto;

import java.util.List;

public interface CarFinanceService {
    CarFinanceDto createCarFinance(CarFinanceDto carFinanceDto);
    List<CarFinanceDto> getAllCarFinances();
    CarFinanceDto getCarFinanceById(Long financeId);
    CarFinanceDto updateCarFinance(Long financeId, CarFinanceDto carFinanceDto);
    void deleteCarFinance(Long financeId);
}

