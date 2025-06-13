package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.domain.port.types.ParkTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaParkTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.ParkTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParkTypeRepositoryAdapter implements ParkTypeRepository {

    private final JpaParkTypeRepository parkTypeRepository;
    private final ParkTypeEntityMapper parkTypeMapper;

    @Override
    public Optional<ParkType> findById(UUID id) {
        return parkTypeRepository.findById(id).map(parkTypeMapper::toDomain);
    }

    @Override
    public Optional<ParkType> findByType(String type) {
        return parkTypeRepository.findByType(type).map(parkTypeMapper::toDomain);
    }

    @Override
    public List<ParkType> findAll() {
        return parkTypeRepository.findAll().stream()
                .map(parkTypeMapper::toDomain)
                .collect(Collectors.toList());
    }


}
