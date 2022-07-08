package com.repository;

import com.entity.JournalContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface JournalContentRepository extends JpaRepository<JournalContent, Long>, JpaSpecificationExecutor<JournalContent> {
}
