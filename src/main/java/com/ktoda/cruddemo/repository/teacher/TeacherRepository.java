package com.ktoda.cruddemo.repository.teacher;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    @Query("select subj.students from Teacher t join t.subjects as subj where t.id = :teacherId")
    Iterable<Student> findAllStudentsOfOwnSubjects(@Param("teacherId") Integer teacherId);

    @Query("select subj.students from Teacher t join t.subjects as subj " +
            "where t.id = :teacherId and subj.id = :subjectId")
    Iterable<Student> findAllStudentsBySubjectId(@Param("teacherId") Integer teacherId,
                                                 @Param("subjectId") Integer subjectId);


}
