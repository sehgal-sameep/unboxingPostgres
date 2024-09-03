package com.codewithsam.unboxingPostgres.services.impl;

import com.codewithsam.unboxingPostgres.entities.Bill;
import com.codewithsam.unboxingPostgres.exceptions.ResourceNotFoundException;
import com.codewithsam.unboxingPostgres.payloads.BillDto;
import com.codewithsam.unboxingPostgres.repositories.BillRepo;
import com.codewithsam.unboxingPostgres.services.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepo billRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BillDto createBill(BillDto billDto) {
        Bill bill = this.modelMapper.map(billDto, Bill.class);
        Bill savedBill = this.billRepo.save(bill);
        return this.modelMapper.map(savedBill, BillDto.class);
    }

    @Override
    public List<BillDto> getAllBills() {
        List<Bill> bills = this.billRepo.findAll();
        List<BillDto> billDtos = bills.stream().map(bill -> this.modelMapper.map(bill, BillDto.class)).collect(Collectors.toList());
        return billDtos;
    }

    @Override
    public BillDto getBillById(Integer billId) {
        Bill bill = this.billRepo.findById(billId)
                .orElseThrow(()-> new ResourceNotFoundException("Bill","Id",billId));
        return this.modelMapper.map(bill, BillDto.class);
    }
}
