package com.ktoda.cruddemo.dao;

import com.ktoda.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    Student findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);

}
