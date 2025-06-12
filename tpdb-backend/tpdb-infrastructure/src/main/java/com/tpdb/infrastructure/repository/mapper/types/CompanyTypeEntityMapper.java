package com.tpdb.infrastructure.repository.mapper.types;


import com.tpdb.domain.model.types.CompanyType;
import com.tpdb.infrastructure.repository.entity.types.CompanyTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class CompanyTypeEntityMapper {

    public CompanyType toDomain(CompanyTypeEntity entity) {
        return CompanyType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }
    public CompanyTypeEntity toEntity(CompanyType domain) {
        return CompanyTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
