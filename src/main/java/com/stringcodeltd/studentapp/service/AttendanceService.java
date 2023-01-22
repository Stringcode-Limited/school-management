package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.AttendanceRepository;
import com.stringcodeltd.studentapp.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }

    //coming soon
    public List<Attendance> getAttendanceByCourse(){return null;}


}
