package com.service;

import com.dto.JournalHeaderDTO;
import com.entity.JournalHeader;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface JournalHeaderService extends CRUDService<JournalHeaderDTO>,
        RSQLSearch<JournalHeader> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<JournalHeaderDTO> search(String query);
}
