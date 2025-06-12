package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.ShopType;
import com.tpdb.infrastructure.repository.entity.types.ShopTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ShopTypeEntityMapper {


    public ShopType toDomain(ShopTypeEntity entity) {
        return ShopType.builder()
                .id(entity.getId())
                .type(entity.getType())
                .description(entity.getDescription())
                .build();
    }

    public ShopTypeEntity toEntity(ShopType domain) {
        return ShopTypeEntity.builder()
                .id(domain.getId())
                .type(domain.getType())
                .description(domain.getDescription())
                .build();
    }
}
