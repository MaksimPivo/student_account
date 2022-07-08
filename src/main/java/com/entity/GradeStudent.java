package com.entity;

import com.dto.DisciplineDTO;
import com.dto.JournalContentDTO;
import lombok.Data;

import java.util.List;

@Data
public class GradeStudent {
    private DisciplineDTO disciplineDTO;
    private List<JournalContentDTO> journalContentDTOS;
}
