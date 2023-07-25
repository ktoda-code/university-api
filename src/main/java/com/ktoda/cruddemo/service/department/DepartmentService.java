package com.ktoda.cruddemo.service.department;

import com.ktoda.cruddemo.entity.department.Department;
import com.ktoda.cruddemo.entity.subject.Subject;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import com.ktoda.cruddemo.exception.department.DepartmentNotFoundException;
import com.ktoda.cruddemo.repository.department.DepartmentRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements CrudService<Department> {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(String name, String description, List<Teacher> teachers, List<Subject> subjects) {
        Department department = new Department(name, description, teachers, subjects);
        return departmentRepository.save(department);
    }

    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found!"));
    }
}
