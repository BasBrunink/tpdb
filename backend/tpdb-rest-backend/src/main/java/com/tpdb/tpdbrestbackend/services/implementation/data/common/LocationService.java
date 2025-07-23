package com.tpdb.tpdbrestbackend.services.implementation.data.common;

import com.tpdb.domain.data.common.Location;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.common.LocationRepository;
import com.tpdb.tpdbrestbackend.services.usecases.data.common.LocationUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class LocationService implements LocationUseCase {

    private final LocationRepository locationRepository;

    @Transactional
    @Override
    public Location create(Location location) {
        location.setCreatedAt(LocalDateTime.now());
        location.setUpdatedAt(LocalDateTime.now());
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> findById(UUID id) {
        return locationRepository.findById(id);
    }

    @Override
    public Optional<Location> findByCountry(String country) {
        return locationRepository.findByCountry(country);
    }

    @Override
    public Optional<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
    }
}


