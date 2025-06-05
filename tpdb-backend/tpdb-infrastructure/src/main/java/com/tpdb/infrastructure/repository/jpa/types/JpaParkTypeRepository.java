package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.infrastructure.repository.entity.types.ParkTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaParkTypeRepository extends JpaRepository<ParkTypeEntity, UUID> {


    Optional<ParkType> findByType(String type);
}
