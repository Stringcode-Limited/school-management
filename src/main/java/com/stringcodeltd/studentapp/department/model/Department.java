package com.stringcodeltd.studentapp.department.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stringcodeltd.studentapp.model.Course;
import com.stringcodeltd.studentapp.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "students", "hibernateLazyInitializer", "handler", "course"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long departmentID;
    @Valid
//    @ManyToOne
//    @JoinColumn(name = "departmentID")
    @Column
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Course> course;

    @OneToMany(mappedBy = "department")
    private Set<Student> students;

}
