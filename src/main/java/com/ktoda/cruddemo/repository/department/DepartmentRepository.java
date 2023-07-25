package com.ktoda.cruddemo.repository.department;

import com.ktoda.cruddemo.entity.department.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
