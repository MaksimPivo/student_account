package com.service.impl;

import com.dto.DisciplineDTO;
import com.dto.TimetableDTO;
import com.entity.Student;
import com.entity.Timetable;
import com.mapper.Mapper;
import com.repository.StudentRepository;
import com.repository.TimetableRepository;
import com.security.ConvertTokenToMap;
import com.service.TimetableService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImpl extends CommonCRUDServiceImpl<Timetable, TimetableDTO, TimetableRepository> implements TimetableService {
    public TimetableServiceImpl() {
        super(Timetable.class, TimetableDTO.class);
    }

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<TimetableDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }

        return mapper.toDTOs(timetableRepository.findAll(getSpecifications(query)), DisciplineDTO.class);
    }

    @Override
    public Specification<Timetable> getSpecifications(String query) {
        return TimetableService.super.getSpecifications(query);
    }

    public List<TimetableDTO> getTimetableByGroup() {
        Integer field = (Integer) ConvertTokenToMap.getFieldFromAuthentificationDetails("id_from_source");
        Student student = studentRepository.findByIdFromSource(Long.parseLong(field.toString()));
        return (List<TimetableDTO>) mapper.toDTOs(timetableRepository.findByGroupName(student.getGroup().getName()), TimetableDTO.class);
    }
}
