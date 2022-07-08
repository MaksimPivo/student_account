package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

import java.util.List;

@Data
public class JournalSiteDTO extends AbstractDTO {

    private DisciplineDTO discipline;
    private TeacherDTO teacher;
    private GroupDTO group;
    private Integer streamId;
    private Long pattentIdFromSource;
    private List<JournalHeaderDTO> journalHeaders;
}
