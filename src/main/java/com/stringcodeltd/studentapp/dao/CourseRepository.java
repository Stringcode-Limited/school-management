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

    @Query(value = "DELETE FROM Course o WHERE o.courseCode = :courseCode")
    void deleteByCourseCode(@Param("courseCode") String courseCode);


}
