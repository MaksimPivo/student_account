package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

@Data
public class TeacherDTO extends AbstractDTO {

    private String surname;
    private String name;
    private String patronymic;
}
