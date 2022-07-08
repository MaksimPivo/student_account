package com.service;

import com.dto.JournalContentDTO;
import com.entity.JournalContent;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface JournalContentService extends CRUDService<JournalContentDTO>, RSQLSearch<JournalContent> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<JournalContentDTO> search(String query);
}
