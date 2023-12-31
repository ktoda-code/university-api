package com.ktoda.cruddemo.old.dao;

import com.ktoda.cruddemo.entity.student.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    Student findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);

}
