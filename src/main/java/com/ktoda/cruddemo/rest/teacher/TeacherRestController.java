package com.ktoda.cruddemo.rest.teacher;

import com.ktoda.cruddemo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherRestController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
}
