package com.service;

import com.dto.SubGroupDTO;
import com.entity.SubGroup;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface SubGroupService extends CRUDService<SubGroupDTO>, RSQLSearch<SubGroup> {
    List<SubGroupDTO> search(String query);
}
