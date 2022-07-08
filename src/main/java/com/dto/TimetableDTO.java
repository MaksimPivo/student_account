package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

import java.time.LocalDate;


@Data
public class TimetableDTO extends AbstractDTO {

    private LocalDate lessonDate;
    private Integer lessonNumber;
    private String disciplineName;
    private String typeClassName;
    private String groupName;
    //???
    private Integer subGroup;
    //???
    private String frame;
    private String location;
    private String teacherFio;
}
