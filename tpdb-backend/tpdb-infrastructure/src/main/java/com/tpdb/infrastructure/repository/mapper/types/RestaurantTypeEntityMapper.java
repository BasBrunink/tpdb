package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.RestaurantType;
import com.tpdb.infrastructure.repository.entity.types.RestaurantTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantTypeEntityMapper {

    public RestaurantType toDomain(RestaurantTypeEntity entity) {
        return RestaurantType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }
    public RestaurantTypeEntity toEntity(RestaurantType domain) {
        return RestaurantTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
