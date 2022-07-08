package com.repository;

import com.entity.TypeClass;
import com.repository.utils.RelationWithParentIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeClassRepository
        extends JpaRepository<TypeClass, Long>, JpaSpecificationExecutor<TypeClass>, RelationWithParentIdentifiers<TypeClass> {
}
