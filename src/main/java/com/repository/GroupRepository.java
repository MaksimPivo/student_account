package com.repository;

import com.entity.Group;
import com.repository.utils.RelationWithParentIdentifiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupRepository
        extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group>, RelationWithParentIdentifiers<Group> {
}
