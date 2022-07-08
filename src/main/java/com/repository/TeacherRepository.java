package com.repository;

import com.entity.Teacher;
import com.repository.utils.RelationWithParentIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository
        extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher>, RelationWithParentIdentifiers<Teacher> {
    Teacher findByIdFromSource(Long sourceId);

}
