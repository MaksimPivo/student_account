package com.service.impl;

import com.dto.SubGroupDTO;
import com.entity.SubGroup;
import com.mapper.Mapper;
import com.repository.SubGroupRepository;
import com.service.SubGroupService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubGroupServiceImpl extends CommonCRUDServiceImpl<SubGroup, SubGroupDTO, SubGroupRepository>
        implements SubGroupService {

    @Autowired
    private Mapper<SubGroup, SubGroupDTO> mapper;

    @Autowired
    private SubGroupRepository subGroupRepository;

    public SubGroupServiceImpl() {
        super(SubGroup.class, SubGroupDTO.class);
    }

    @Override
    public List<SubGroupDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(subGroupRepository.findAll(getSpecifications(query)), SubGroupDTO.class);
    }
}
