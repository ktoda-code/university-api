package com.ktoda.cruddemo.entity.office;

import com.ktoda.cruddemo.entity.teacher.Teacher;
import com.ktoda.cruddemo.entity.department.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private Integer id;
    @Column(name = "office_number")
    private Integer officeNumber;
    private Integer floor;
    @Column(name = "building_number")
    private Integer buildingNumber;
    @OneToOne(mappedBy = "office")
    private Teacher teacher;

    public Office(Integer officeNumber, Integer floor, Teacher teacher) {
        this.officeNumber = officeNumber;
        this.floor = floor;
        this.teacher = teacher;
        this.buildingNumber = assignBuildingNumber(teacher.getDepartment());
    }

    private Integer assignBuildingNumber(Department department) {
        // Hard coded but for now it is enough
        switch (department.getName()) {
            case "AI" -> {
                return 0;
            }
            case "SE" -> {
                return 1;
            }
            case "CO" -> {
                return 2;
            }
            case "HW" -> {
                return 3;
            }
            default -> {
                return -1;
            }
        }
    }


}
