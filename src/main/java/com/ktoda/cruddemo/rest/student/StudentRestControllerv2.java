package com.ktoda.cruddemo.rest.student;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/university")
public class StudentRestControllerv2 {
    private final StudentService studentService;

    @Autowired
    public StudentRestControllerv2(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students/{firstName}")
    public ResponseEntity<Iterable<Student>> findAllStudentsOfStudentInSubjects(@PathVariable String firstName) {
        return ResponseEntity.ok(studentService.findAllStudentsOfStudentInSubjectsByFirstName(firstName));
    }

    @GetMapping("students")
    public ResponseEntity<Iterable<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("students/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.findStudentById(studentId));
    }

    @PostMapping("students")
    public ResponseEntity<Student> save(@RequestBody String firstName,
                                        @RequestBody String lastName,
                                        @RequestBody String password) {
        return ResponseEntity.ok(studentService.save(firstName, lastName, password));
    }

    @PutMapping("students/{studentId}/{subjectId}")
    public ResponseEntity<Student> assignSubject(@PathVariable Integer subjectId,
                                                 @PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.assignSubject(subjectId, studentId));
    }

    @PutMapping("students/{studentId}/{subjectId}/{grade}")
    public ResponseEntity<Student> gradeStudent(@PathVariable Integer studentId,
                                                @PathVariable Double grade,
                                                @PathVariable Integer subjectId) {
        return ResponseEntity.ok(studentService.gradeStudent(subjectId, studentId, grade));
    }

    @DeleteMapping("students/{studentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer studentId) {
        studentService.deleteById(studentId);
        return ResponseEntity.noContent().build();

    }

}
