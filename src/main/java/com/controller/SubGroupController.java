package com.controller;

import com.dto.SubGroupDTO;
import com.service.SubGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("sub_groups")
public class SubGroupController {

    @Autowired
    private SubGroupService subGroupService;

    @GetMapping("search")
    public List<SubGroupDTO> search(@RequestParam("q") String query) {
        return subGroupService.search(query);
    }
}
