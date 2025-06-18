package com.tpdb.infrastructure.repository.mapper;

import com.tpdb.domain.model.Park;
import com.tpdb.domain.model.types.ParkType;
import com.tpdb.infrastructure.repository.entity.ParkEntity;
import com.tpdb.infrastructure.repository.entity.types.ParkTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ParkEntityMapper {

    public Park toDomain(ParkEntity e) {
        return Park.builder()
                .id(e.getId())
                .name(e.getName())
//                .location(e.getLocation())
                .parkType(ParkType.builder()
                        .id(e.getParkType().getId())
                        .type(e.getParkType().getType())
                        .description(e.getParkType().getDescription())
                        .build())
                .build();
    }

    public ParkEntity toEntity(Park domain, ParkTypeEntity typeEntity) {
        return ParkEntity.builder()
                .name(domain.getName())
                .id(domain.getId())
//                .location(domain.getLocation())
                .parkType(typeEntity)
                .build();
    }
}
