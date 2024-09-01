package com.codewithsam.unboxingPostgres.services;

import com.codewithsam.unboxingPostgres.payloads.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Integer id);

}
