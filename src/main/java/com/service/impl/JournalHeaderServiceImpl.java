package com.service.impl;

import com.dto.*;
import com.entity.JournalHeader;
import com.mapper.Mapper;
import com.repository.JournalHeaderRepository;
import com.service.JournalHeaderService;
import com.service.common.impl.CommonCRUDServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalHeaderServiceImpl
        extends CommonCRUDServiceImpl<JournalHeader, JournalHeaderDTO, JournalHeaderRepository>
        implements JournalHeaderService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private JournalHeaderRepository journalHeaderRepository;

    public JournalHeaderServiceImpl() {
        super(JournalHeader.class, JournalHeaderDTO.class);
    }

    @Override
    public List<JournalHeaderDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(journalHeaderRepository.findAll(getSpecifications(query)),
                JournalHeaderDTO.class);
    }
}
