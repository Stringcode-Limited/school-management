package com.stringcodeltd.studentapp.courseRegisteration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stringcodeltd.studentapp.model.Student;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
public class Course {
    @Id
    @Column()
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;
    @Column()
    @NotNull()
    private String courseCode;
    @Column
    @NotNull()
    private String courseTitle;
    @Column
    @NotNull()
    @Min(100)
    @Max(500)
    private int courseLevel;
    @Column
    @NotNull()
    private String courseDepartment;

    @ManyToMany(mappedBy = "course")
    private Set<Student> student = new HashSet<>();
}
