package com.ktoda.cruddemo.repository.student;

import com.ktoda.cruddemo.entity.student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class for <code>Student</code> entities.
 *
 * @author Konstantin Andreev
 * @see Student
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("select s from Student s order by s.lastName")
    Iterable<Student> findAllOrderByLastName();

    @Query("select s from Student s order by s.firstName")
    Iterable<Student> findAllOrderByFirstName();

    Student findStudentByLastName(String lastName);

    Iterable<Student> findStudentsByEmailLike(String email);

    Optional<Student> findStudentByUsername(String username);

    Student findStudentByFirstNameOrLastName(String firstName, String lastName);
}
