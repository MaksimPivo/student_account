package com.service;

import com.dto.TeacherDTO;
import com.entity.Teacher;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface TeacherService
        extends CRUDService<TeacherDTO>, RSQLSearch<Teacher> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<TeacherDTO> search(String query);
}
