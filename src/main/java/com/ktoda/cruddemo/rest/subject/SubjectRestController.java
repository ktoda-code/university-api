package com.ktoda.cruddemo.rest.subject;

import com.ktoda.cruddemo.entity.subject.Subject;
import com.ktoda.cruddemo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/university")
public class SubjectRestController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("subjects/{studentId}")
    public ResponseEntity<Iterable<Subject>> findAllSubjectsOfStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(subjectService.findAllSubjectsOfStudentById(studentId));
    }
}
