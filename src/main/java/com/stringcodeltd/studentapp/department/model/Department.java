package com.stringcodeltd.studentapp.department.model;

import com.stringcodeltd.studentapp.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentID;
    @Valid
    @ManyToOne
    @JoinColumn(name = "department_id")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private Set<Student> students;

}
