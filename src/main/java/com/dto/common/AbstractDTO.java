package com.dto.common;

import com.entity.common.Status;
import lombok.Data;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class AbstractDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
}
