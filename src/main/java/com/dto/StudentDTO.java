package com.dto;

import com.dto.common.AbstractDTO;
import lombok.Data;

//@EqualsAndHashCode(callSuper = false)
@Data
public class StudentDTO extends AbstractDTO {

    private String surname;
    private String name;
    private String patronymic;

}
