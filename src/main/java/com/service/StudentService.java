package com.service;

import com.dto.StudentDTO;
import com.entity.Student;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface StudentService
        extends CRUDService<StudentDTO>, RSQLSearch<Student> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<StudentDTO> search(String query);
}
