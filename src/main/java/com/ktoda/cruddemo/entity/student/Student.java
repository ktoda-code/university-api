package com.ktoda.cruddemo.entity.student;

import com.ktoda.cruddemo.entity.Role;
import jakarta.persistence.*;
import lombok.*;
import nl.flotsam.xeger.Xeger;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_id", unique = true)
    private String studentId;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Student(String password, String firstName, String lastName, String email) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = generateStudentId();
        this.role = Role.STUDENT;
        this.active = true;
    }

    public Student(Student student) {
        this(
                student.getPassword(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

    private String generateStudentId() {
        String regex = getFirstName().toLowerCase() + "[0-9]{3}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
