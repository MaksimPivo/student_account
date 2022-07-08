package com.controller;

import com.dto.TimetableDTO;
import com.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("timetable")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("timetableByGroup")
    public List<TimetableDTO> getTimetableByGroup() {
        return timetableService.getTimetableByGroup();
    }
}
