package com.service.impl;

import com.dto.JournalContentDTO;
import com.entity.JournalContent;
import com.mapper.Mapper;
import com.repository.JournalContentRepository;
import com.service.JournalContentService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalContentServiceImpl
        extends CommonCRUDServiceImpl<JournalContent, JournalContentDTO, JournalContentRepository>
        implements JournalContentService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private JournalContentRepository journalContentRepository;

    public JournalContentServiceImpl() {
        super(JournalContent.class, JournalContentDTO.class);
    }

    @Override
    public List<JournalContentDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(journalContentRepository.findAll(getSpecifications(query)), JournalContentDTO.class);
    }
}
