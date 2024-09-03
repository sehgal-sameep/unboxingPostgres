package com.codewithsam.unboxingPostgres.repositories;

import com.codewithsam.unboxingPostgres.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Integer> {
}
