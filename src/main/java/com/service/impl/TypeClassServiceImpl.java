package com.service.impl;

import com.dto.TypeClassDTO;
import com.entity.TypeClass;
import com.mapper.Mapper;
import com.repository.TypeClassRepository;
import com.service.TypeClassService;
import com.service.common.impl.CommonCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeClassServiceImpl
        extends CommonCRUDServiceImpl<TypeClass, TypeClassDTO, TypeClassRepository>
        implements TypeClassService {

    @Autowired
    private Mapper<TypeClass, TypeClassDTO> mapper;

    @Autowired
    private TypeClassRepository typeClassRepository;

    public TypeClassServiceImpl() {
        super(TypeClass.class, TypeClassDTO.class);
    }

    @Override
    public List<TypeClassDTO> search(String query) {
        if (query.isEmpty()) {
            return findAll();
        }
        return mapper.toDTOs(typeClassRepository.findAll(getSpecifications(query)), TypeClassDTO.class);
    }
}
