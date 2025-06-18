package com.tpdb.domain.port.common;

import com.tpdb.domain.model.common.Location;

import java.util.Optional;
import java.util.UUID;

public interface LocationRepository {

    Location save(Location location);
    Optional<Location> findById(UUID id);
}
