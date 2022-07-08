package com.controller;

import com.dto.DisciplineDTO;
import com.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("search")
    public List<DisciplineDTO> search(@RequestParam("q") String query) {
        return disciplineService.search(query);
    }

    @GetMapping("searchDisciplinesByTeacher")
    public List<DisciplineDTO> getDisciplinesByGroup(@RequestParam("q") String query) {
        return disciplineService.getDisciplinesByGroup(query);
    }
}
