package com.service.impl;

import com.dto.TeacherDTO;
import com.entity.Teacher;
import com.mapper.Mapper;
import com.repository.TeacherRepository;
import com.service.TeacherService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl
        extends CommonCRUDServiceImpl<Teacher, TeacherDTO, TeacherRepository>
        implements TeacherService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherServiceImpl() {
        super(Teacher.class, TeacherDTO.class);
    }

    @Override
    public List<TeacherDTO> search(String query) {

        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(teacherRepository.findAll(getSpecifications(query)), TeacherDTO.class);
    }
}
