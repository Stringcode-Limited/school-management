package com.stringcodeltd.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teacher_details")
public class Teacher {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "teacher_id")
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


}

