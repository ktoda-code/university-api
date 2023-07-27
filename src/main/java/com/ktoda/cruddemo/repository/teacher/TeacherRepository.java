package com.ktoda.cruddemo.repository.teacher;

import com.ktoda.cruddemo.entity.teacher.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    @Query("select t from Teacher t where t.department.name = :departmentName")
    Iterable<Teacher> findAllTeachersByDepartmentName(@Param("departmentName") String departmentName);

    Optional<Teacher> findTeacherByUsername(String username);
}
