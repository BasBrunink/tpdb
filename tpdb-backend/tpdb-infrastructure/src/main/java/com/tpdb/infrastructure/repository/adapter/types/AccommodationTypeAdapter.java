package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.AccommodationType;
import com.tpdb.domain.port.types.AccommodationTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaAccommodationTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.AccommodationTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccommodationTypeAdapter implements AccommodationTypeRepository {

    private final JpaAccommodationTypeRepository accommodationTypeRepository;
    private final AccommodationTypeEntityMapper accommodationTypeMapper;

    @Override
    public Optional<AccommodationType> findById(UUID id) {
        return accommodationTypeRepository.findById(id).map(accommodationTypeMapper::toDomain);
    }

    @Override
    public Optional<AccommodationType> findByType(String type) {
        return accommodationTypeRepository.findByType(type).map(accommodationTypeMapper::toDomain);
    }

    @Override
    public List<AccommodationType> findAll() {
        return accommodationTypeRepository.findAll().stream()
                .map(accommodationTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
