package com.service;

import com.dto.TimetableDTO;
import com.entity.Timetable;
import com.service.common.CRUDService;
import com.service.common.RSQLSearch;

import java.util.List;

public interface TimetableService extends CRUDService<TimetableDTO>, RSQLSearch<Timetable> {
    List<TimetableDTO> search(String query);

    List<TimetableDTO> getTimetableByGroup();
}
