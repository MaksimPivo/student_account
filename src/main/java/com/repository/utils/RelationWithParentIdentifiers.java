package com.repository.utils;

import com.entity.common.AbstractEntity;

public interface RelationWithParentIdentifiers<E extends AbstractEntity> {

    E findByIdFromSource(Long id);
}
