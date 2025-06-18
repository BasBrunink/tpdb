package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.ResortTypeUseCase;
import com.tpdb.domain.model.types.ResortType;
import com.tpdb.domain.port.types.ResortTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ResortTypeService implements ResortTypeUseCase {

    private final ResortTypeRepository resortTypeRepository;


    @Override
    public Optional<ResortType> findById(UUID id) {
        return resortTypeRepository.findById(id);
    }

    @Override
    public Optional<ResortType> findByType(String type) {
        return resortTypeRepository.findByType(type);
    }

    @Override
    public List<ResortType> findAll() {
        return resortTypeRepository.findAll();
    }
}
