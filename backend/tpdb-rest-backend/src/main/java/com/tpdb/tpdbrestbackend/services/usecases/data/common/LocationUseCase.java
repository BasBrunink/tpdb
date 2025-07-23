package com.tpdb.tpdbrestbackend.services.usecases.data.common;

import com.tpdb.domain.data.common.Location;

import java.util.Optional;
import java.util.UUID;

public interface LocationUseCase {
    Location create(Location location);
    Optional<Location> findById(UUID id);
    Optional<Location> findByCountry(String country);
    Optional<Location> findByCity(String city);

}
