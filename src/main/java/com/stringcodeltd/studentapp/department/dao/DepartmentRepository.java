package com.stringcodeltd.studentapp.department.dao;

import com.stringcodeltd.studentapp.department.model.Department;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Boolean existsByDepartmentName(String department);
    @Query(value = "SELECT o from Department o WHERE o.departmentName= :departmentname")
    List<Department> findByDepartmentName(@Param("departmentname") String departmentName);
}
