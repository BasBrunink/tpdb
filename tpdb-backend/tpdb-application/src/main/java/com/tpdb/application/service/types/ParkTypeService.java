package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.ParkTypeUseCase;
import com.tpdb.domain.model.types.ParkType;
import com.tpdb.domain.port.types.ParkTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ParkTypeService implements ParkTypeUseCase {

    private final ParkTypeRepository parkTypeRepository;

    @Override
    public Optional<ParkType> findById(UUID id) {
        return parkTypeRepository.findById(id);
    }

    @Override
    public Optional<ParkType> findByType(String type) {
        return parkTypeRepository.findByType(type);
    }

    @Override
    public List<ParkType> findAll() {
        return parkTypeRepository.findAll();
    }
}
