package com.ktoda.cruddemo.rest.teacher;

import com.ktoda.cruddemo.entity.teacher.Teacher;
import com.ktoda.cruddemo.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/university")
public class TeacherRestController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("teachers")
    public ResponseEntity<Iterable<Teacher>> findAll() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("teachers/{teacherId}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Integer teacherId) {
        return ResponseEntity.ok(teacherService.findTeacherById(teacherId));
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.save(teacher));
    }

    @DeleteMapping("teachers/{teacherId}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable Integer teacherId) {
        teacherService.deleteById(teacherId);
        return ResponseEntity.noContent().build();
    }
}
