package com.ktoda.cruddemo.service;

import com.ktoda.cruddemo.entity.Student;
import com.ktoda.cruddemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student findStudentByLastName(String lastName) {
        return studentRepository.findStudentByLastName(lastName);
    }

    public Iterable<Student> findAllOrderByLastName() {
        return studentRepository.findAllOrderByLastName();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public Iterable<Student> findStudentsByEmailLike(String email) {
        return studentRepository.findStudentsByEmailLike(email);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudentById(student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getId());
    }

    public long count() {
        return studentRepository.count();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
