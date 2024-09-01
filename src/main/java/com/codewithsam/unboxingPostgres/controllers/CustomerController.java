package com.codewithsam.unboxingPostgres.controllers;

import com.codewithsam.unboxingPostgres.payloads.CustomerDto;
import com.codewithsam.unboxingPostgres.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto)
    {
        CustomerDto createdCustomerDto= this.customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    }

    @GetMapping("/customers/")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/customers/{custId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer custId) {
        return ResponseEntity.ok(this.customerService.getCustomerById(custId));
    }
}
