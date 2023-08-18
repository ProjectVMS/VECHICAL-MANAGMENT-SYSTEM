package com.app.service;

import com.app.dto.UsersDTO;
import com.app.entity.Users;

import java.util.List;

public interface UsersService {
    Users addUser(UsersDTO usersDTO);
    void deleteUser(Long userId);
    Users updateUser(Long userId, UsersDTO usersDTO);
    List<Users> findAllUsers();
    Users findUserById(Long userId);
    List<Users> findUsersByBookingCarId(Long carId);
}