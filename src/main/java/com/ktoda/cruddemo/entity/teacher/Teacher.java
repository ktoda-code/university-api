package com.ktoda.cruddemo.entity.teacher;

import com.ktoda.cruddemo.entity.subject.Subject;
import com.ktoda.cruddemo.entity.university.Department;
import com.ktoda.cruddemo.entity.university.Role;
import com.ktoda.cruddemo.entity.university.UniversityPersonal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.flotsam.xeger.Xeger;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends UniversityPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", unique = true)
    private Integer id;
    @OneToOne(mappedBy = "teacher")
    private Office office;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Max(3)
    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;

    public Teacher(String password, String firstName, String lastName, String email, Role role) {
        super(password, firstName, lastName, email, Role.TEACHER);
    }

    @Override
    public String generateUsername() {
        String regex = "[a-zA-Z0-9]{4}" + getFirstName().toLowerCase().substring(0, 4);
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
