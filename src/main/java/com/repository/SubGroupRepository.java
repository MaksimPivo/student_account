package com.repository;

import com.entity.SubGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubGroupRepository extends JpaRepository<SubGroup, Long>, JpaSpecificationExecutor<SubGroup> {
}
