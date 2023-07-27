package com.ktoda.cruddemo.rest.techpersonal;

import com.ktoda.cruddemo.entity.techpersonal.TechPersonal;
import com.ktoda.cruddemo.service.student.StudentService;
import com.ktoda.cruddemo.service.subject.SubjectService;
import com.ktoda.cruddemo.service.teacher.TeacherService;
import com.ktoda.cruddemo.service.techpersonal.TechPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/university")
public class TechPersonalRestController {
    private final TechPersonalService techPersonalService;

    @Autowired
    public TechPersonalRestController(TechPersonalService techPersonalService) {
        this.techPersonalService = techPersonalService;
    }

    @GetMapping("tech")
    public ResponseEntity<Iterable<TechPersonal>> findAll() {
        return ResponseEntity.ok(techPersonalService.findAll());
    }

}
