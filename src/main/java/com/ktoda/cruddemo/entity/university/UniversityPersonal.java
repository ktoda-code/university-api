package com.ktoda.cruddemo.entity.university;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class UniversityPersonal {
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UniversityPersonal(String password, String firstName, String lastName, String email, Role role, String username) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = true;
        this.role = role;
        this.username = username;
    }
}
