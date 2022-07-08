package com.service;

import com.dto.TypeClassDTO;
import com.entity.TypeClass;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface TypeClassService
        extends CRUDService<TypeClassDTO>, RSQLSearch<TypeClass> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<TypeClassDTO> search(String query);
}
