package com.service.impl;

import com.dto.GroupDTO;
import com.dto.JournalHeaderDTO;
import com.dto.JournalSiteDTO;
import com.entity.JournalSite;
import com.mapper.Mapper;
import com.repository.JournalSiteRepository;
import com.service.*;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JournalSiteServiceImpl
        extends CommonCRUDServiceImpl<JournalSite, JournalSiteDTO, JournalSiteRepository>
        implements JournalSiteService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private JournalSiteRepository journalSiteRepository;

    public JournalSiteServiceImpl() {
        super(JournalSite.class, JournalSiteDTO.class);
    }

    @Override
    public List<JournalSiteDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(journalSiteRepository.findAll(getSpecifications(query)), JournalSiteDTO.class);
    }

    @Override
    public List<GroupDTO> searchByTeacherAndDiscipline(String query) {
        Set<String> groupSet = new HashSet<>();
        search(query).forEach(journalSiteDTO -> groupSet.add(journalSiteDTO.getGroup().getName()));
        List<GroupDTO> groupDTOS = new ArrayList<>();
        groupSet.forEach(s -> {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setName(s);
            groupDTOS.add(groupDTO);
        });
        return groupDTOS;
    }

    private List<JournalHeaderDTO> getJournalHeadersFromJournalSite(List<JournalSiteDTO> journalSites) {
        List<JournalHeaderDTO> journalHeaderDTOs = new ArrayList<>();
        journalSites.forEach(journalSiteDTO -> journalHeaderDTOs.addAll(journalSiteDTO.getJournalHeaders()));
        return journalHeaderDTOs;
    }

    @Override
    public List<JournalSiteDTO> getByDisciplineName(String disciplineName) {
        return mapper.toDTOs(journalSiteRepository.findByDisciplineName(disciplineName), JournalSiteDTO.class);
    }

    private String parsingFIOTeacher(String fio) {
        fio = fio.replace("\'", "").replace(".", " ");
        String[] temp = fio.split(" ");
        return String.format("surname==%s;name==%s*;patronymic==%s*", temp[0], temp[1], temp[2]);
    }
}
