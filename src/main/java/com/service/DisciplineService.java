package com.service;

import com.dto.DisciplineDTO;
import com.entity.Discipline;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface DisciplineService
        extends CRUDService<DisciplineDTO>, RSQLSearch<Discipline> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<DisciplineDTO> search(String query);

    List<DisciplineDTO> getDisciplinesByGroup(String query);
}
