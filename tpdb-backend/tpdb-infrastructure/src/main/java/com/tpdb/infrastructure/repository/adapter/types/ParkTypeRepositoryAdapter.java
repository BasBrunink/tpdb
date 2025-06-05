package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.domain.port.types.ParkTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaParkTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.ParkTypeInfraStrucureMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParkTypeRepositoryAdapter implements ParkTypeRepository {

    private final JpaParkTypeRepository parkTypeRepository;
    private final ParkTypeInfraStrucureMapper parkTypeInfraStrucureMapper;

    @Override
    public Optional<ParkType> findById(UUID id) {
        return parkTypeRepository.findById(id).map(parkTypeInfraStrucureMapper::toDomain);
    }

    @Override
    public Optional<ParkType> findByType(String type) {
        return parkTypeRepository.findByType(type);
    }

    @Override
    public List<ParkType> findAll() {
        return parkTypeRepository.findAll().stream()
                .map(parkTypeInfraStrucureMapper::toDomain)
                .collect(Collectors.toList());
    }


}
