package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.ResortType;
import com.tpdb.domain.port.types.ResortTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaResortTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.ResortTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ResortTypeRepositoryAdapter implements ResortTypeRepository {

    private final JpaResortTypeRepository resortTypeRepository;
    private final ResortTypeEntityMapper resortTypeMapper;
    @Override
    public Optional<ResortType> findById(UUID id) {
        return resortTypeRepository.findById(id).map(resortTypeMapper::toDomain);
    }

    @Override
    public Optional<ResortType> findByType(String type) {
        return resortTypeRepository.findByType(type).map(resortTypeMapper::toDomain);
    }

    @Override
    public List<ResortType> findAll() {
        return resortTypeRepository.findAll().stream()
                .map(resortTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
