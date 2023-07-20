package com.ktoda.cruddemo.old.dao;

import com.ktoda.cruddemo.entity.student.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager em;
//    private final DataSource ds;

    @Autowired
    public StudentDAOImpl(EntityManager em, DataSource ds) {
        this.em = em;
//        this.ds = ds;
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        return em.merge(student);
    }

    @Override
    public void deleteById(Integer id) {
        Student student = findById(id);
        em.remove(student);
    }
}
