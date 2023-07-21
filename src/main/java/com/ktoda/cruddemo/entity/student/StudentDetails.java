package com.ktoda.cruddemo.entity.student;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class StudentDetails implements UserDetails {
    private final Student student;

    public StudentDetails(Student student) {
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + student.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return student.getActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return student.getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return student.getActive();
    }

    @Override
    public boolean isEnabled() {
        return student.getActive();
    }
}
