package com.service.impl;

import com.dto.DisciplineDTO;
import com.dto.JournalContentDTO;
import com.entity.Discipline;
import com.entity.GradeStudent;
import com.entity.JournalContent;
import com.entity.Student;
import com.mapper.Mapper;
import com.repository.StudentRepository;
import com.security.ConvertTokenToMap;
import com.service.GradeStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeStudentServiceImpl implements GradeStudentService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<GradeStudent> getJournalContentByDiscipline() {
        Integer field = (Integer) ConvertTokenToMap.getFieldFromAuthentificationDetails("id_from_source");
        Student student = studentRepository.findByIdFromSource(Long.parseLong(field.toString()));
        List<Discipline> disciplines = student.getGroup().getDisciplines();
        List<GradeStudent> gradeStudents = new ArrayList<>();
        List<JournalContent> journalContents;
        for (Discipline discipline : disciplines) {
            GradeStudent gradeStudent = new GradeStudent();
            gradeStudent.setDisciplineDTO((DisciplineDTO) mapper.toDTO(discipline, DisciplineDTO.class));
            journalContents = student.getJournalContents().stream().filter(a -> a.getJournalHeader().getJournalSite().getDiscipline().equals(discipline)).collect(Collectors.toList());
            gradeStudent.setJournalContentDTOS(mapper.toDTOs(journalContents, JournalContentDTO.class));
            gradeStudents.add(gradeStudent);
        }
        return gradeStudents;
    }
}
