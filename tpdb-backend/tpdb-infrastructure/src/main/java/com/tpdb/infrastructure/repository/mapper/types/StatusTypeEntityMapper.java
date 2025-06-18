package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.StatusType;
import com.tpdb.infrastructure.repository.entity.types.StatusTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class StatusTypeEntityMapper {
    public StatusType toDomain(StatusTypeEntity entity) {
        return StatusType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }

    public StatusTypeEntity toEntity(StatusType domain) {
        return StatusTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
