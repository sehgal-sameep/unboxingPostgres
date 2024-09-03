package com.codewithsam.unboxingPostgres.repositories;

import com.codewithsam.unboxingPostgres.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll,Integer> {
}
