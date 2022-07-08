package com.service.impl;

import com.dto.GroupDTO;
import com.entity.Group;
import com.mapper.Mapper;
import com.repository.GroupRepository;
import com.service.GroupService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl
        extends CommonCRUDServiceImpl<Group, GroupDTO, GroupRepository>
        implements GroupService {

    @Autowired
    private Mapper<Group, GroupDTO> mapper;

    @Autowired
    private GroupRepository groupRepository;

    public GroupServiceImpl() {
        super(Group.class, GroupDTO.class);
    }

    @Override
    public List<GroupDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(groupRepository.findAll(getSpecifications(query)), GroupDTO.class);
    }
}
