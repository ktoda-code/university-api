package com.ktoda.cruddemo.rest.department;

import com.ktoda.cruddemo.entity.department.Department;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import com.ktoda.cruddemo.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/university/")
public class DepartmentRestController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("departments")
    public ResponseEntity<Iterable<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("departments/{departmentId}")
    public ResponseEntity<Department> findById(@PathVariable Integer departmentId) {
        return ResponseEntity.ok(departmentService.findById(departmentId));
    }

    @PostMapping("departments/{name}/{description}")
    public ResponseEntity<Department> save(@PathVariable String name,
                                           @PathVariable String description) {
        return ResponseEntity.ok(departmentService.save(name, description, List.of(), List.of()));
    }

    @PostMapping("departments")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.save(department));
    }

    @DeleteMapping("departments/{departmentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer departmentId) {
        departmentService.deleteById(departmentId);
        return ResponseEntity.noContent().build();
    }


}
