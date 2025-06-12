package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.StatusType;
import com.tpdb.domain.port.types.StatusTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaStatusTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.StatusTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StatusTypeRepositoryAdapter implements StatusTypeRepository {

    private final JpaStatusTypeRepository statusTypeRepository;
    private final StatusTypeEntityMapper statusTypeMapper;

    @Override
    public Optional<StatusType> findById(UUID id) {
        return statusTypeRepository.findById(id)
                .map(statusTypeMapper::toDomain);
    }

    @Override
    public Optional<StatusType> findByType(String type) {
        return statusTypeRepository.findByType(type)
                .map(statusTypeMapper::toDomain);
    }

    @Override
    public List<StatusType> findAll() {
        return statusTypeRepository.findAll().stream()
                .map(statusTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
