package com.tpdb.domain.port.types;

import com.tpdb.domain.model.types.StatusType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StatusTypeRepository {
    Optional<StatusType> findById(UUID id);
    Optional<StatusType> findByType(String type);
    List<StatusType> findAll();
}
