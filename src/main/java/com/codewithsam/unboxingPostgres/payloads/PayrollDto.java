package com.codewithsam.unboxingPostgres.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PayrollDto {
    private int id;
    private String empName;
    private int salary;
}
