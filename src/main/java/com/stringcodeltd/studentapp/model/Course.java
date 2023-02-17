package com.stringcodeltd.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.stringcodeltd.studentapp.department.model.Department;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "student"})
public class Course {
    @Id
    @Column()
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    @Column()
    @NotNull()
    @PrimaryKeyJoinColumn
    private String courseCode;
    @Column
    @NotNull()
    private String courseTitle;
    @Column
    @NotNull()
    @Min(100)
    @Max(500)
    private int courseLevel;
//    @NotNull
    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department department;

    @ManyToMany(mappedBy = "course")
    private Set<Student> student = new HashSet<>();

}
