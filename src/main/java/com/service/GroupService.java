package com.service;

import com.dto.GroupDTO;
import com.entity.Group;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface GroupService
        extends CRUDService<GroupDTO>, RSQLSearch<Group> {
    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<GroupDTO> search(String query);
}
