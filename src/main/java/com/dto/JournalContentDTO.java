package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

@Data
public class JournalContentDTO extends AbstractDTO{

    private Boolean presence;
    private Short lateness;
    private Integer grade;
    private String discription;
    private JournalHeaderDTO journalHeader;
}
