package com.ktoda.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;
import nl.flotsam.xeger.Xeger;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "student")
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

    public Student(String password, String firstName, String lastName, String email) {
        this.studentId = generateStudentId();
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String generateStudentId() {
        String regex = getFirstName().toLowerCase() + "[0-9]{3}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }
}
