package com.tpdb.tpdbrestbackend.persistence.jpa.data.common;

import com.tpdb.domain.data.common.Location;
import com.tpdb.tpdbrestbackend.persistence.entities.data.common.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaLocationRepository extends JpaRepository<LocationEntity, UUID> {
    Optional<LocationEntity> findByCountry(String country);

    Optional<LocationEntity> findByCity(String city);
}
