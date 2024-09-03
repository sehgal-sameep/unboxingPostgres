package com.codewithsam.unboxingPostgres.services.impl;

import com.codewithsam.unboxingPostgres.entities.Payroll;
import com.codewithsam.unboxingPostgres.exceptions.ResourceNotFoundException;
import com.codewithsam.unboxingPostgres.payloads.PayrollDto;
import com.codewithsam.unboxingPostgres.repositories.PayrollRepo;
import com.codewithsam.unboxingPostgres.services.PayrollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PayrollRepo payrollRepo;

    @Override
    public PayrollDto createPayroll(PayrollDto payrollDto) {
        Payroll payRoll = this.modelMapper.map(payrollDto, Payroll.class);
        Payroll savedPayroll = this.payrollRepo.save(payRoll);
        return this.modelMapper.map(savedPayroll, PayrollDto.class);
    }

    @Override
    public PayrollDto getPayrollById(Integer id) {
        Payroll payroll = this.payrollRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll", "Id", id));
        return this.modelMapper.map(payroll, PayrollDto.class);
    }

    @Override
    public List<PayrollDto> getAllPayrolls() {
        List<Payroll> payRolls = this.payrollRepo.findAll();
        List<PayrollDto> payrollDtos = payRolls.stream().map(payroll -> this.modelMapper.map(payroll, PayrollDto.class)).collect(Collectors.toList());
        return payrollDtos;
    }
}
