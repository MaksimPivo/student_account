package com.repository;

import com.entity.JournalHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JournalHeaderRepository extends JpaRepository<JournalHeader, Long>, JpaSpecificationExecutor<JournalHeader> {
    JournalHeader getById(Long id);
}
