package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.CompanyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCompanyTypeRepository extends JpaRepository<CompanyTypeEntity, UUID> {

    Optional<CompanyTypeEntity> findByType(String type);
}
