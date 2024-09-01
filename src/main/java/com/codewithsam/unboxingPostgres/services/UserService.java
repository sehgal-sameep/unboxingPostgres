package com.codewithsam.unboxingPostgres.services;

import com.codewithsam.unboxingPostgres.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUsers(Integer userId);
}
