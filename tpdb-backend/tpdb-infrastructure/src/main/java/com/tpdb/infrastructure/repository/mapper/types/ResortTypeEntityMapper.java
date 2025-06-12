package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.ResortType;
import com.tpdb.infrastructure.repository.entity.types.ResortTypeEntity;
import com.tpdb.infrastructure.repository.entity.types.RestaurantTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ResortTypeEntityMapper {

    public ResortType toDomain(ResortTypeEntity entity) {
        return ResortType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }
    public RestaurantTypeEntity toEntity(ResortType domain) {
        return RestaurantTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
