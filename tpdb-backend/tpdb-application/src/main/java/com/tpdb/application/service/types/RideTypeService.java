package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.RideTypeUseCase;
import com.tpdb.domain.model.types.RideType;
import com.tpdb.domain.port.types.RideTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class RideTypeService implements RideTypeUseCase {

    private final RideTypeRepository rideTypeRepository;

    @Override
    public Optional<RideType> findById(UUID id) {
        return rideTypeRepository.findById(id);
    }

    @Override
    public Optional<RideType> findByType(String type) {
        return rideTypeRepository.findByType(type);
    }

    @Override
    public List<RideType> findAll() {
        return rideTypeRepository.findAll();
    }
}
