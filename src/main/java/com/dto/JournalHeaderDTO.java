package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class JournalHeaderDTO extends AbstractDTO {

    private Integer subGroup;
    private String classTopic;
    private String discription;
    private LocalDate dateOfLesson;
    private Integer hoursCount;
    private TypeClassDTO typeClass;
}
