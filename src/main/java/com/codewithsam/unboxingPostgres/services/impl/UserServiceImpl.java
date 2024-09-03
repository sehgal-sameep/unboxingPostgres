package com.codewithsam.unboxingPostgres.services.impl;

import com.codewithsam.unboxingPostgres.entities.Role;
import com.codewithsam.unboxingPostgres.entities.User;
import com.codewithsam.unboxingPostgres.exceptions.ResourceNotFoundException;
import com.codewithsam.unboxingPostgres.payloads.UserDto;
import com.codewithsam.unboxingPostgres.repositories.RoleRepo;
import com.codewithsam.unboxingPostgres.repositories.UserRepo;
import com.codewithsam.unboxingPostgres.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
//
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        String pword = user.getPassword();
        String encodedPassword = this.passwordEncoder.encode(pword);
        user.setPassword(encodedPassword);

        Set<Role> roles = userDto.getRoles().stream()
                .map(roleName -> roleRepo.findByName(roleName).orElseThrow(() ->
                        new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());
        user.setRoles(roles);

        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

//    @Override
//    public UserDto updateUser(UserDto userDto, Integer userId) {
//        User user=this.userRepo.findById(userId)
//                .orElseThrow(()->new ResourceNotFoundException("User","id",userId));
//
//        user.setAbout(userDto.getAbout());
//        user.setEmail(userDto.getEmail());
//        user.setName(userDto.getName());
//        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
//        User updatedUser=this.userRepo.save(user);
//        UserDto updatedUserDto=this.userToDto(updatedUser);
//        return updatedUserDto;
//    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUsers(Integer userId) {
        User user= this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto)
    {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user)
    {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

}
