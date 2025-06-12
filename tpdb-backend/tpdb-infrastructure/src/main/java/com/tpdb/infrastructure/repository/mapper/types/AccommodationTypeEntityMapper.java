package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.AccommodationType;
import com.tpdb.infrastructure.repository.entity.types.AccommodationTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class AccommodationTypeEntityMapper {

    public AccommodationType toDomain(AccommodationTypeEntity entity) {
        return AccommodationType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }

    public AccommodationTypeEntity toEntity(AccommodationType domain) {
        return AccommodationTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
