package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.RideTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaRideTypeRepository extends JpaRepository<RideTypeEntity, UUID> {
    Optional<RideTypeEntity> findByType(String type);
}
