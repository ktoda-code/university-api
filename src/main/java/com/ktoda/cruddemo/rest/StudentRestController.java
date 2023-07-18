package com.ktoda.cruddemo.rest;

import com.ktoda.cruddemo.entity.Student;
import com.ktoda.cruddemo.exception.StudentRequestException;
import com.ktoda.cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Endpoint for "api/students"
     * <br>
     * This method returns a list of all students.
     *
     * @return Iterable&lt;Student&gt; - the list of students
     * @see Student
     */
    @GetMapping("/students")
    public Iterable<Student> findAllStudents() {
        return studentService.findAll();
    }


    /**
     * Endpoint for "api/students/{studentId}"
     * <br>
     * This method returns a student with a specific id. If the student doesn't exist, it throws a {@link StudentRequestException}.
     *
     * @param studentId Integer - the id of the student
     * @return Student - the student
     * @throws StudentRequestException if student doesn't exist
     * @see Student
     * @see StudentRequestException
     */
    @GetMapping("/students/{studentId}")
    public Student findStudentById(@PathVariable Integer studentId) {
        return studentService.findStudentById(studentId)
                .orElseThrow(() -> new StudentRequestException("No student found with id {" + studentId + "}"));
    }
}
