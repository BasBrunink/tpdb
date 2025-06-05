package com.tpdb.application.port.in.data.types.parktype;

import com.tpdb.domain.model.types.ParkType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkTypeUseCase {
    Optional<ParkType> findById(UUID id);
    Optional<ParkType> findByType(String type);
    List<ParkType> findAll();
}
