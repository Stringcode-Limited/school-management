package com.stringcodeltd.studentapp.dao;

import com.stringcodeltd.studentapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "SELECT o FROM Course o WHERE o.courseTitle = :courseTitle")
    Course findByCourseTitle(@Param("courseTitle") String courseTitle);

    @Query(value = "SELECT o FROM Course o WHERE o.courseCode = :courseCode")
    Course findByCourseCode(@Param("courseCode") String courseCode);

    @Query(value = "SELECT o FROM Course o WHERE o.courseDepartment = :courseDepartment")
    Course filterByDepartment(@Param("courseDepartment") String courseDepartment);

    @Query(value = "SELECT o FROM Course o WHERE o.courseDepartment = :courseDepartment AND o.courseLevel = :courseLevel")
    Course filterByDepartmentAndLevel(@Param("courseDepartment") String courseDepartment, @Param("courseLevel") int courseLevel);

    @Query(value = "SELECT o FROM Course o WHERE o.courseDepartment = :courseDepartment AND o.courseLevel < :courseLevel")
    Course filterByDepartmentAndLevelforCO(@Param("courseDepartment") String courseDepartment, @Param("courseLevel") int courseLevel);

    @Query(value = "SELECT o FROM Course o WHERE o.courseDepartment != :courseDepartment AND o.courseLevel = :courseLevel")
    Course getBorrowedCourses(@Param("courseDepartment") String courseDepartment, @Param("courseLevel") int courseLevel);

    @Query(value = "SELECT o FROM Course o WHERE o.courseDepartment != :courseDepartment AND o.courseLevel < :courseLevel")
    Course getCOBorrowedCourses(@Param("courseDepartment") String courseDepartment, @Param("courseLevel") int courseLevel);
}
