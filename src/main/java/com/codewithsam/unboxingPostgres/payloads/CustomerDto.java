package com.codewithsam.unboxingPostgres.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String name;
    private String email;
}
