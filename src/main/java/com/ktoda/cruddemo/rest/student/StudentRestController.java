package com.ktoda.cruddemo.rest.student;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.exception.student.StudentRequestException;
import com.ktoda.cruddemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a REST controller that handles HTTP requests related to students.
 * It provides endpoints for retrieving, adding, and finding students.
 *
 * @author Konstantin Andreev
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Returns a list of all students.
     *
     * @return ResponseEntity&lt;Iterable&lt;Student&gt;&gt; - the list of students
     * @see Student
     */
    @GetMapping("/students")
    public ResponseEntity<Iterable<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    /**
     * Returns a student with a specific id.
     * If the student doesn't exist, it throws a {@link StudentRequestException}.
     *
     * @param studentId Integer - the id of the student
     * @return ResponseEntity&lt;Student&gt; - the student
     */
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.findStudentById(studentId));
    }

    /**
     * Adds a student.
     *
     * @param student the student to be added
     * @return ResponseEntity&lt;Student&gt; - the new student
     */
    @PostMapping("/students")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    /**
     * Updates a student.
     *
     * @param student the student to be updated
     * @return ResponseEntity&lt;Student&gt; - the updated student
     */
    @PutMapping("/students")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    /**
     * Deletes a student by their ID.
     *
     * @param studentId the ID of the student to be deleted
     * @return ResponseEntity&lt;Void&gt; indicating the status of the deletion
     */
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
        return ResponseEntity.noContent().build();
    }
}
