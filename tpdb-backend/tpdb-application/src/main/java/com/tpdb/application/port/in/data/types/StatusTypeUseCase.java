package com.tpdb.application.port.in.data.types;

import com.tpdb.domain.model.types.StatusType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StatusTypeUseCase {
    Optional<StatusType> findById(UUID id);
    Optional<StatusType> findByType(String type);
    List<StatusType> findAll();
}
