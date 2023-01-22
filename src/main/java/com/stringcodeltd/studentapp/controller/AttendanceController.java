package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.model.Attendance;
import com.stringcodeltd.studentapp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vi/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping()
    public List<Attendance> getall(){
        return attendanceService.getAllAttendance();
    }



}
