package com.ktoda.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;
import nl.flotsam.xeger.Xeger;
import org.springframework.security.core.userdetails.UserDetails;

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
    @Column(name = "student_id")
    private String studentId;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    // we can have roles(authorities), enabled, status,...

    public Student(String password, String firstName, String lastName, String email) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentId = generateStudentId();
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
