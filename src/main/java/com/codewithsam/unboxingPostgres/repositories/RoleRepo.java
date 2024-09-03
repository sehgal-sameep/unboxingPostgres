package com.codewithsam.unboxingPostgres.repositories;

import com.codewithsam.unboxingPostgres.entities.Role;
import com.codewithsam.unboxingPostgres.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String name);
}
