package com.codewithsam.unboxingPostgres.services.impl;

import com.codewithsam.unboxingPostgres.entities.Customer;
import com.codewithsam.unboxingPostgres.exceptions.ResourceNotFoundException;
import com.codewithsam.unboxingPostgres.payloads.CustomerDto;
import com.codewithsam.unboxingPostgres.repositories.CustomerRepo;
import com.codewithsam.unboxingPostgres.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = this.customerRepo.save(customer);
        return this.modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = this.customerRepo.findAll();
        List<CustomerDto> customerDtos = customers.stream().map(customer -> this.modelMapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerById(Integer custId) {
        Customer customer = this.customerRepo.findById(custId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer","Id",custId));
        return this.modelMapper.map(customer, CustomerDto.class);
    }
}
