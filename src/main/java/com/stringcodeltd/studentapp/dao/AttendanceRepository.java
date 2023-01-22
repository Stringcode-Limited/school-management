package com.stringcodeltd.studentapp.dao;

import com.stringcodeltd.studentapp.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
