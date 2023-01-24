package com.stringcodeltd.studentapp.department.dao;

import com.stringcodeltd.studentapp.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Long, Department> {
}
