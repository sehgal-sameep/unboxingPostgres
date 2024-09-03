package com.codewithsam.unboxingPostgres.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int id;

    private String name;

    private String email;

    private String password;

    private Set<String> roles;

}
