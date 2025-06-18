package com.tpdb.infrastructure.repository.jpa.common;

import com.tpdb.domain.model.common.Location;
import com.tpdb.infrastructure.repository.entity.common.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JpaLocationRepository extends JpaRepository<LocationEntity, UUID> {
}
