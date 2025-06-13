package com.tpdb.application.port.in.data.types;

import com.tpdb.domain.model.types.AccommodationType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccommodationTypeUseCase {
    Optional<AccommodationType> findById(UUID id);
    Optional<AccommodationType> findByType(String type);
    List<AccommodationType> findAll();
}
