package com.ktoda.cruddemo.entity.techpersonal;

import com.ktoda.cruddemo.entity.university.Role;
import com.ktoda.cruddemo.entity.university.UniversityPersonal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tech_personal")
public class TechPersonal extends UniversityPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public TechPersonal(String password, String firstName, String lastName, String email, Role role) {
        super(password, firstName, lastName, email, Role.ADMIN);
    }

    @Override
    public String generateUsername() {
        return "admin@" + getFirstName().toLowerCase();
    }
}
