package com.ktoda.cruddemo.service;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.exception.*;
import com.ktoda.cruddemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Student findStudentByStudentId(String studentId) {
        return studentRepository.findStudentByStudentId(studentId)
                .orElseThrow(() -> new StudentRequestNotFoundException("User not found"));
    }

    /**
     * Retrieves a student with a specific ID.
     *
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     * @throws StudentRequestException if no student is found with the given ID
     * @see Student
     * @see StudentRequestException
     * @see StudentRequestNotFoundException
     */
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentRequestNotFoundException("No student found with id {" + id + "}"));
    }

    public Student findStudentByLastName(String lastName) {
        return studentRepository.findStudentByLastName(lastName);
    }

    public Iterable<Student> findAllOrderByLastName() {
        return studentRepository.findAllOrderByLastName();
    }

    /**
     * This method saves a student.
     * If the student already exist, it throws a {@link StudentRequestException}.
     *
     * @param student the student to be added
     * @return Student - the added student
     * @throws StudentRequestException if student already exist
     * @see Student
     * @see StudentRequestException
     * @see StudentRequestAlreadyExistsException
     */
    public Student save(Student student) {
        try {
            if (findStudentById(student.getId()).getId().equals(student.getId())) {
                throw new StudentRequestAlreadyExistsException("Student already exists!");
            }
        } catch (StudentRequestNotFoundException e) {
            // No student found, it is safe to save the new student
            Student s = new Student(student);
            return studentRepository.save(s);
        }

        throw new StudentRequestException("Error creating student. Unable to determine the cause.");
    }

    /**
     * Updates a student with new information.
     *
     * @param student the student object containing the updated information
     * @return the updated student
     * @throws StudentRequestException if no student is found with the given ID
     * @see Student
     * @see StudentRequestException
     * @see StudentRequestNotFoundException
     */
    public Student update(Student student) {
        findStudentById(student.getId());
        return studentRepository.save(student);
    }

    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public Iterable<Student> findStudentsByEmailLike(String email) {
        return studentRepository.findStudentsByEmailLike(email);
    }

    public void updateStudent(Student student) { // This is the same as using the save(student)
        studentRepository.updateStudentById(student.getFirstName(), student.getLastName(), student.getEmail(), student.getId());
    }

    public long count() {
        return studentRepository.count();
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to be deleted
     * @throws StudentRequestNotFoundException if no student is found with the given ID
     * @see StudentRequestNotFoundException
     */
    @Transactional
    public void deleteById(Integer id) {
        Integer studentId = findStudentById(id).getId();
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
