package com.codewithsam.unboxingPostgres.controllers;

import com.codewithsam.unboxingPostgres.payloads.ApiResponse;
import com.codewithsam.unboxingPostgres.payloads.UserDto;
import com.codewithsam.unboxingPostgres.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    //POST- create user
    @PostMapping("/user/")
    @PreAuthorize("isAuthenticated() and hasRole('ADMIN')")
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto)
    {
        UserDto createdUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    @PreAuthorize("isAuthenticated() and hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUsers(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    //GET- get user
    @GetMapping("/users/")
    @PreAuthorize("isAuthenticated() and hasRole('ADMIN')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/users/{userId}")
    @PreAuthorize("isAuthenticated() and hasRole('ADMIN')")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
