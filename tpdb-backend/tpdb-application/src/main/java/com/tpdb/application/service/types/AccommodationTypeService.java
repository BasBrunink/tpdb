package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.AccommodationTypeUseCase;

import com.tpdb.domain.model.types.AccommodationType;
import com.tpdb.domain.port.types.AccommodationTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class AccommodationTypeService implements AccommodationTypeUseCase {

    private final AccommodationTypeRepository accommodationTypeRepository;
    @Override
    public Optional<AccommodationType> findById(UUID id) {
        return accommodationTypeRepository.findById(id);
    }

    @Override
    public Optional<AccommodationType> findByType(String type) {
        return accommodationTypeRepository.findByType(type);
    }

    @Override
    public List<AccommodationType> findAll() {
        return accommodationTypeRepository.findAll();
    }
}
