package com.ktoda.cruddemo.repository;

import com.ktoda.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>Student</code> entities.
 *
 * @author Konstantin Andreev
 * @see Student
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("select s from  Student s order by s.lastName")
    Iterable<Student> findAllOrderByLastName();

    Student findStudentByLastName(String lastName);

    Iterable<Student> findStudentsByEmailLike(String email);

    @Transactional
    @Modifying
    @Query("update Student s set s.firstName=?1, s.lastName=?2, s.email=?3 where s.id=?4 ")
    void updateStudentById(String firstName, String lastName, String email, Integer id);
}
