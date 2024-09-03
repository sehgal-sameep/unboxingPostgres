package com.codewithsam.unboxingPostgres.services;


import com.codewithsam.unboxingPostgres.payloads.BillDto;

import java.util.List;

public interface BillService {

    BillDto createBill(BillDto billDto);
    List<BillDto> getAllBills();
    BillDto getBillById(Integer id);
}
