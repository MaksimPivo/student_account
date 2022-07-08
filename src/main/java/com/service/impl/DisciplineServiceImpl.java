package com.service.impl;

import com.dto.DisciplineDTO;
import com.entity.Discipline;
import com.mapper.Mapper;
import com.repository.DisciplineRepository;
import com.service.DisciplineService;
import com.service.JournalSiteService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplineServiceImpl
        extends CommonCRUDServiceImpl<Discipline, DisciplineDTO, DisciplineRepository>
        implements DisciplineService {

    @Autowired
    private Mapper<Discipline, DisciplineDTO> mapper;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private JournalSiteService journalSiteService;

    public DisciplineServiceImpl() {
        super(Discipline.class, DisciplineDTO.class);
    }

    @Override
    public List<DisciplineDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(disciplineRepository.findAll(getSpecifications(query)), DisciplineDTO.class);
    }

    @Override
    public List<DisciplineDTO> getDisciplinesByGroup(String query) {
        Set<Long> set = new HashSet<>();
        journalSiteService.search(query).forEach(journalSiteDTO -> set.add(journalSiteDTO.getDiscipline().getId()));

        List<DisciplineDTO> disciplineDTOs = new ArrayList<>();
        set.stream().forEach(s -> {
            DisciplineDTO disciplineDTO = mapper.toDTO(disciplineRepository.getById(s), DisciplineDTO.class);
            disciplineDTOs.add(disciplineDTO);
        });

        return disciplineDTOs;
    }
}
