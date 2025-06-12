package com.tpdb.application.port.in.data.types;

import com.tpdb.domain.model.types.ResortType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ResortTypeUseCase {
    Optional<ResortType> findById(UUID id);
    Optional<ResortType> findByType(String type);
    List<ResortType> findAll();
}
