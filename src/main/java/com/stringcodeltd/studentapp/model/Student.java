package com.stringcodeltd.studentapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stringcodeltd.studentapp.courseRegisteration.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="student_details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @JsonIgnore
    private Long id;
    @Column
    @NotNull()
    private String firstName;
    @Column
    @NotNull(message = "Lastname must not be null")
    private String LastName;
    @Column
    @NotNull()
    private String gender;
    @Column
    @NotNull
    private String department;
    @Column
    @NotNull
    @Min(100)
    @Max(500)
    private long level;

    @Column
    @JsonIgnore
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date registeredDate;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_student_id", referencedColumnName = "student_id")
    private List<Address> address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> course = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
            name = "assigned_project",
            joinColumns =  @JoinColumn(name = "student_id") ,
            inverseJoinColumns =  @JoinColumn(name = "project_id")
    )
    private Set<Project> project=new HashSet<>();




}
