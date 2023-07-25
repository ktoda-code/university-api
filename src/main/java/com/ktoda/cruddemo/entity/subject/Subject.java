package com.ktoda.cruddemo.entity.subject;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.entity.department.Department;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;
    @Column(name = "subject_code", unique = true)
    private String subjectCode;
    private String name;
    private String description;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Language> languages;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Size(min = 10, max = 120,
            message = "A subject must have at least 10 students and at most 120 students.")
    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToOne
    private Department department;
    @ElementCollection(targetClass = Double.class)
    private List<Double> grades;

    public Subject(String subjectCode, String name, String description, List<Language> languages,
                   Teacher teacher, List<Student> students, Department department, List<Double> grades) {
        this.name = name;
        this.description = description;
        this.languages = languages;
        this.teacher = teacher;
        this.students = students;
        this.department = department;
        this.grades = grades;
        this.subjectCode = subjectCode;
    }
}
