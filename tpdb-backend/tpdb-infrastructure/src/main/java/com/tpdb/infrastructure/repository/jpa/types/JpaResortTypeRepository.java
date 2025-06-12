package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.ResortTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaResortTypeRepository extends JpaRepository<ResortTypeEntity, UUID> {
    Optional<ResortTypeEntity> findByType(String type);
}
