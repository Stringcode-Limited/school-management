package com.stringcodeltd.studentapp.dao;

import com.stringcodeltd.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT o FROM Student o WHERE o.department= :dept")
    List<Student> findByDept(@Param("dept") String dept);





    //getLevel(
//    @Query(value="SELECT o from Student o Where o.level= :level")
//    List<Student> findBylevel(@Param("level") Long level);
}
