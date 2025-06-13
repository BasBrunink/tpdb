package com.tpdb.domain.port.types;

import com.tpdb.domain.model.types.RideType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RideTypeRepository {
    Optional<RideType> findById(UUID id);
    Optional<RideType> findByType(String type);
    List<RideType> findAll();
}
