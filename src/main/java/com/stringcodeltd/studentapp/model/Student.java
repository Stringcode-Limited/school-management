package com.stringcodeltd.studentapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="student_details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;



}
