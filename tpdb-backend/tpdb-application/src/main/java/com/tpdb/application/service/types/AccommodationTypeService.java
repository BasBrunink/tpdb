package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.AccommodationTypeUseCase;
import com.tpdb.domain.model.Accomodation;
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
        return Optional.empty();
    }

    @Override
    public Optional<AccommodationType> findByType(String type) {
        return Optional.empty();
    }

    @Override
    public List<AccommodationType> findAll() {
        return List.of();
    }
}
