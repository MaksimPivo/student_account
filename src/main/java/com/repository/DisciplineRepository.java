package com.repository;

import com.entity.Discipline;
import com.repository.utils.RelationWithParentIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DisciplineRepository
        extends JpaRepository<Discipline, Long>, JpaSpecificationExecutor<Discipline>, RelationWithParentIdentifiers<Discipline> {
}
