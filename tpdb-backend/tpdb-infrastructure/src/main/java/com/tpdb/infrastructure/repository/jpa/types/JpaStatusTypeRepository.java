package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.StatusTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaStatusTypeRepository extends JpaRepository<StatusTypeEntity, UUID> {
    Optional<StatusTypeEntity> findByType(String type);
}
