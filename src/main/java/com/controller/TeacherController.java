package com.controller;

import com.dto.TeacherDTO;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Secured("USER")
    @GetMapping("search")
    public List<TeacherDTO> search(@RequestParam("q") String query) {
        return teacherService.search(query);
    }

}
