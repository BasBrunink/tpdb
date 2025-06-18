package com.tpdb.infrastructure.repository.adapter.common;

import com.tpdb.domain.model.common.Location;
import com.tpdb.domain.port.common.LocationRepository;
import com.tpdb.infrastructure.repository.jpa.common.JpaLocationRepository;
import com.tpdb.infrastructure.repository.mapper.common.LocationEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class LocationRepositoryAdapter implements LocationRepository {

    private final JpaLocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;


    @Override
    public Location save(Location location) {
        return locationEntityMapper.toDomain(locationRepository.save(
                locationEntityMapper.toEntity(location)
        ));
    }

    @Override
    public Optional<Location> findById(UUID id) {
        return locationRepository.findById(id).map(locationEntityMapper::toDomain);
    }
}
