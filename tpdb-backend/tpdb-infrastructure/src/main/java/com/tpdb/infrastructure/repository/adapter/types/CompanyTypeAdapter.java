package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.CompanyType;
import com.tpdb.domain.port.types.CompanyTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaCompanyTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.CompanyTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CompanyTypeAdapter implements CompanyTypeRepository {

    private final JpaCompanyTypeRepository companyTypeRepository;
    private final CompanyTypeEntityMapper companyTypeMapper;

    @Override
    public Optional<CompanyType> findById(UUID id) {
        return companyTypeRepository.findById(id).map(companyTypeMapper::toDomain);
    }

    @Override
    public Optional<CompanyType> findByType(String type) {
        return companyTypeRepository.findByType(type).map(companyTypeMapper::toDomain);
    }

    @Override
    public List<CompanyType> findAll() {
        return companyTypeRepository.findAll().stream()
                .map(companyTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
