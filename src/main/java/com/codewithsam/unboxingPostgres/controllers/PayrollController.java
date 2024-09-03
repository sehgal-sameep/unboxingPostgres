package com.codewithsam.unboxingPostgres.controllers;

import com.codewithsam.unboxingPostgres.payloads.CustomerDto;
import com.codewithsam.unboxingPostgres.payloads.PayrollDto;
import com.codewithsam.unboxingPostgres.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/payroll/")
    @PreAuthorize("isAuthenticated() and hasRole('HR')")
    public ResponseEntity<PayrollDto> createPayroll(@RequestBody PayrollDto payrollDto)
    {
        PayrollDto savedPayrollDto = this.payrollService.createPayroll(payrollDto);
        return new ResponseEntity<>(savedPayrollDto, HttpStatus.CREATED);
    }

    @GetMapping("/payrolls/")
    @PreAuthorize("isAuthenticated() and hasAnyRole('HR','ACCOUNTANT')")
    public ResponseEntity<List<PayrollDto>> getAllPayrolls() {
        List<PayrollDto> payrollDtos = this.payrollService.getAllPayrolls();
        return new ResponseEntity<>(payrollDtos,HttpStatus.OK);
    }

    @GetMapping("/payrolls/{payrollId}")
    @PreAuthorize("isAuthenticated() and hasAnyRole('HR','ACCOUNTANT')")
    public ResponseEntity<PayrollDto> getPayrollById(@PathVariable Integer payrollId) {
        PayrollDto payrollDto = this.payrollService.getPayrollById(payrollId);
        return new ResponseEntity<>(payrollDto,HttpStatus.OK);
    }
}
