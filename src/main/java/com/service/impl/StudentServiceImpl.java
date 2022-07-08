package com.service.impl;

import com.dto.StudentDTO;
import com.entity.Student;
import com.mapper.Mapper;
import com.repository.StudentRepository;
import com.service.JournalSiteService;
import com.service.StudentService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl
        extends CommonCRUDServiceImpl<Student, StudentDTO, StudentRepository>
        implements StudentService {

    @Autowired
    private Mapper<Student, StudentDTO> mapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JournalSiteService journalSiteService;

    public StudentServiceImpl() {
        super(Student.class, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(studentRepository.findAll(getSpecifications(query)), StudentDTO.class);
    }
}
