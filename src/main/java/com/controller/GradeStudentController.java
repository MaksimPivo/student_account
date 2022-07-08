package com.controller;

import com.entity.GradeStudent;
import com.service.GradeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("grade-student")
public class GradeStudentController {

    @Autowired
    private GradeStudentService gradeStudentService;

    @GetMapping("grade")
    public List<GradeStudent> getGrade() {
        return gradeStudentService.getJournalContentByDiscipline();
    }
}
