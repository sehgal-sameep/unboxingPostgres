package com.codewithsam.unboxingPostgres.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

//    @Column
//    private int role_id;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
}
