package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.StatusTypeUseCase;
import com.tpdb.domain.model.types.StatusType;
import com.tpdb.domain.port.types.StatusTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class StatusTypeService implements StatusTypeUseCase {

    private final StatusTypeRepository statusTypeRepository;

    @Override
    public Optional<StatusType> findById(UUID id) {
        return statusTypeRepository.findById(id);
    }

    @Override
    public Optional<StatusType> findByType(String type) {
        return statusTypeRepository.findByType(type);
    }

    @Override
    public List<StatusType> findAll() {
        return statusTypeRepository.findAll();
    }
}
