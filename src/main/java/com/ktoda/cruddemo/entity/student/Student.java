package com.ktoda.cruddemo.entity.student;

import java.util.List;

import com.ktoda.cruddemo.entity.university.Role;
import com.ktoda.cruddemo.entity.university.UniversityPersonal;
import com.ktoda.cruddemo.entity.subject.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import nl.flotsam.xeger.Xeger;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student extends UniversityPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true)
    private Integer id;
    @Size(min = 1, max = 12, message = "A student can have at most 12 subjects and at least 1.")
    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    public Student(String password, String firstName, String lastName, String email, List<Subject> subjects) {
        super(password, firstName, lastName, email, Role.STUDENT);
        this.subjects = subjects;
    }

    public Student(Student student) {
        this(
                student.getPassword(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getSubjects());
    }

    public String generateUsername() {
        String regex = getFirstName().toLowerCase() + "[0-9]{3}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
