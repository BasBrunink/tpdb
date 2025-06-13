package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.RideType;
import com.tpdb.infrastructure.repository.entity.types.RideTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class RideTypeEntityMapper {
    public RideType toDomain(RideTypeEntity entity) {
        return RideType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }
    public RideTypeEntity toEntity(RideType domain) {
        return RideTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
 }
