package com.stringcodeltd.studentapp.department.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartmentController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;
    private String departmentName;

}
