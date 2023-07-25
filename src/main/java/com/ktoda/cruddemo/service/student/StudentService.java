package com.ktoda.cruddemo.service.student;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.exception.student.StudentAlreadyExistsException;
import com.ktoda.cruddemo.exception.student.StudentRequestException;
import com.ktoda.cruddemo.exception.student.StudentNotFoundException;
import com.ktoda.cruddemo.repository.student.StudentRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import com.ktoda.cruddemo.service.utility.UserService;
import nl.flotsam.xeger.Xeger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements UserService, CrudService<Student> {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found!"));
    }

    public Student findStudentByUsername(String username) {
        return studentRepository.findStudentByUsername(username)
                .orElseThrow(() -> new StudentNotFoundException("User not found"));
    }

    /**
     * Retrieves a student with a specific ID.
     *
     * @param id the ID of the student to retrieve
     * @return the student with the specified ID
     * @throws StudentRequestException if no student is found with the given ID
     * @see Student
     * @see StudentRequestException
     * @see StudentNotFoundException
     */
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("No student found with id {" + id + "}"));
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
     * @see StudentAlreadyExistsException
     */
    public Student save(Student student) {
        try {
            if (findStudentById(student.getId()).getId().equals(student.getId())) {
                throw new StudentAlreadyExistsException("Student already exists!");
            }
        } catch (StudentNotFoundException e) {
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
     * @see StudentNotFoundException
     */
    public Student update(Student student) {
        findStudentById(student.getId());
        return studentRepository.save(student);
    }

    @Transactional
    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    public Iterable<Student> findStudentsByEmailLike(String email) {
        return studentRepository.findStudentsByEmailLike(email);
    }

    public long count() {
        return studentRepository.count();
    }

    /**
     * Deletes a student by their ID.
     *
     * @param id the ID of the student to be deleted
     * @throws StudentNotFoundException if no student is found with the given ID
     * @see StudentNotFoundException
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

    Student findStudentByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findStudentByFirstNameOrLastName(firstName, lastName);
    }

    public Iterable<Student> findAllStudentsOfTeacherById(Integer teacherId) {
        return studentRepository.findAllStudentsOfTeacherById(teacherId);
    }

    public Iterable<Student> findAllStudentsBySubjectIdAndTeacherId(Integer teacherId, Integer subjectId) {
        return studentRepository.findAllStudentsBySubjectIdAndTeacherId(teacherId, subjectId);
    }

    @Override
    public String generateUsername(String firstName) {
        String regex = firstName.toLowerCase() + "[0-9]{3}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
