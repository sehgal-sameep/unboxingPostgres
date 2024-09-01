package com.codewithsam.unboxingPostgres.repositories;

import com.codewithsam.unboxingPostgres.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
