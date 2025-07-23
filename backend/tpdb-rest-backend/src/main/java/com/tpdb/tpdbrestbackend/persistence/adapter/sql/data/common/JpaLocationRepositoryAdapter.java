package com.tpdb.tpdbrestbackend.persistence.adapter.sql.data.common;

import com.tpdb.domain.data.common.Location;
import com.tpdb.tpdbrestbackend.persistence.jpa.data.common.JpaLocationRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.data.common.LocationEntityMapper;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.common.LocationRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class JpaLocationRepositoryAdapter implements LocationRepository {

    private final JpaLocationRepository locationRepository;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public Location save(Location location) {
        return locationEntityMapper.toDomain(
                locationRepository.save(locationEntityMapper.toEntity(location))
        );
    }

    @Override
    public Optional<Location> findById(UUID id) {
        return locationRepository.findById(id).map(locationEntityMapper::toDomain);
    }

    @Override
    public Optional<Location> findByCountry(String country) {
        return locationRepository.findByCountry(country).map(locationEntityMapper::toDomain);
    }

    @Override
    public Optional<Location> findByCity(String city) {
        return locationRepository.findByCity(city).map(locationEntityMapper::toDomain);
    }
}
