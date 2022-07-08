package com.repository;

import com.entity.Student;
import com.repository.utils.RelationWithParentIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository
        extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>, RelationWithParentIdentifiers<Student> {

    Student findByIdFromSource(Long souceId);
}
