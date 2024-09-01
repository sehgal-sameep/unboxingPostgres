package com.codewithsam.unboxingPostgres.repositories;

import com.codewithsam.unboxingPostgres.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    //it will be used in customUserDetailService
    Optional<User> findByEmail(String email);

}
