package com.tpdb.domain.port.types;

import com.tpdb.domain.model.types.CompanyType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyTypeRepository {
    Optional<CompanyType> findById(UUID id);
    Optional<CompanyType> findByType(String type);
    List<CompanyType> findAll();
}
