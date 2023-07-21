package com.ktoda.cruddemo.entity.university;

import com.ktoda.cruddemo.entity.subject.Subject;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "department")
    private List<Subject> subjects;

    public Department(String name, String description, List<Teacher> teachers, List<Subject> subjects) {
        this.name = name;
        this.description = description;
        this.teachers = teachers;
        this.subjects = subjects;
    }
}
