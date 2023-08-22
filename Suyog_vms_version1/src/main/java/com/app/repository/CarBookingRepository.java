package com.app.repository;

import com.app.entity.CarBooking;
import com.app.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBookingRepository extends JpaRepository<CarBooking, Long> {
    List<CarBooking> findByUserId(Long userId);
    List<CarBooking> findByCarId(Long carId);
    List<CarBooking> findByUser(Users user);
}
