package com.service;

import com.dto.*;
import com.entity.JournalSite;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface JournalSiteService extends CRUDService<JournalSiteDTO>, RSQLSearch<JournalSite> {

    /**
     * Search changes by params
     *
     * @param query params in RSQL format. Used {@link RSQLSearch}
     * @return list of changes
     */
    List<JournalSiteDTO> search(String query);

    List<GroupDTO> searchByTeacherAndDiscipline(String query);

    List<JournalSiteDTO> getByDisciplineName(String disciplineName);
}
