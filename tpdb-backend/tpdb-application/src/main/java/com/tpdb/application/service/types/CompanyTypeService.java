package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.CompanyTypeUseCase;
import com.tpdb.domain.model.types.CompanyType;
import com.tpdb.domain.port.types.CompanyTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CompanyTypeService implements CompanyTypeUseCase {

    private final CompanyTypeRepository companyTypeRepository;

    @Override
    public Optional<CompanyType> findById(UUID id) {
        return companyTypeRepository.findById(id);
    }

    @Override
    public Optional<CompanyType> findByType(String type) {
        return companyTypeRepository.findByType(type);
    }

    @Override
    public List<CompanyType> findAll() {
        return companyTypeRepository.findAll();
    }
}
