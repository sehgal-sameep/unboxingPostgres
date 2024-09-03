package com.codewithsam.unboxingPostgres.services;

import com.codewithsam.unboxingPostgres.payloads.PayrollDto;
import java.util.List;

public interface PayrollService {

    PayrollDto createPayroll(PayrollDto payrollDto);

    PayrollDto getPayrollById(Integer id);

    List<PayrollDto> getAllPayrolls();

}
