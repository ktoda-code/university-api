package com.ktoda.cruddemo.repository.subject;

import com.ktoda.cruddemo.entity.subject.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    @Query("select s.subjects from Student s where s.id = :studentId")
    Iterable<Subject> findAllSubjectsOfStudentById(@Param("studentId") Integer studentId);

    @Query("select s from Student s join s.subjects subj order by subj.name")
    Iterable<Subject> findAllSubjectsOrderBySubjectName();
}
