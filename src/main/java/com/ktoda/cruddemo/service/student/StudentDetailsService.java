package com.ktoda.cruddemo.service.student;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.entity.student.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {
    private final StudentService studentService;

    @Autowired
    public StudentDetailsService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentService.findStudentByUsername(username);
        return new StudentDetails(student);
    }
}
