package com.codewithsam.unboxingPostgres.controllers;

import com.codewithsam.unboxingPostgres.payloads.BillDto;
import com.codewithsam.unboxingPostgres.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/bill/")
    @PreAuthorize("isAuthenticated() and hasAnyRole('SALES')")
    public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto)
    {
        BillDto createdBillDto= this.billService.createBill(billDto);
        return new ResponseEntity<>(createdBillDto, HttpStatus.CREATED);
    }

    @GetMapping("/bills/")
    @PreAuthorize("isAuthenticated() and hasAnyRole('SALES','ACCOUNTANT')")
    public ResponseEntity<List<BillDto>> getAllBills() {
        return ResponseEntity.ok(this.billService.getAllBills());
    }

    @GetMapping("/bills/{billId}")
    @PreAuthorize("isAuthenticated() and hasAnyRole('SALES','ACCOUNTANT')")
    public ResponseEntity<BillDto> getBillById(@PathVariable Integer billId) {
        return ResponseEntity.ok(this.billService.getBillById(billId));
    }
}
