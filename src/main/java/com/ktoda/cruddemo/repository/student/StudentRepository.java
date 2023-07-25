package com.ktoda.cruddemo.repository.student;

import com.ktoda.cruddemo.entity.student.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    @Query("select subj.students from Teacher t join t.subjects as subj where t.id = :teacherId")
    Iterable<Student> findAllStudentsOfTeacherById(@Param("teacherId") Integer teacherId);

    @Query("select subj.students from Teacher t join t.subjects as subj " +
            "where t.id = :teacherId and subj.id = :subjectId")
    Iterable<Student> findAllStudentsBySubjectIdAndTeacherId(@Param("teacherId") Integer teacherId,
                                                 @Param("subjectId") Integer subjectId);

    @Query("select subj.grades " +
            "from Student s " +
            "join s.subjects subj " +
            "where s.id = :studentId and subj.name = :subjectName")
    Iterable<Double> findAllGradesOfStudentByIdAndBySubjectName(@Param("studentId") Integer studentId,
                                                                @Param("subjectName") String subjectName);
}
