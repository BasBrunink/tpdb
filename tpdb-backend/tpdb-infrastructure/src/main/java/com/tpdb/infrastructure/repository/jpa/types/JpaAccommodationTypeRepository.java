package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.AccommodationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaAccommodationTypeRepository extends JpaRepository<AccommodationTypeEntity, UUID> {
    Optional<AccommodationTypeEntity> findByType(String type);
}
