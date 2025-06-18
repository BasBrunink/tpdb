package com.tpdb.infrastructure.repository.mapper.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.infrastructure.repository.entity.ParkEntity;
import com.tpdb.infrastructure.repository.entity.types.ParkTypeEntity;
import com.tpdb.infrastructure.repository.mapper.ParkEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ParkTypeEntityMapper {

    public final ParkEntityMapper parkEntityMapper;

    public ParkType toDomain(ParkTypeEntity e) {
        return ParkType.builder()
                .id(e.getId())
                .type(e.getType())
                .parks(e.getParks().stream().map(parkEntityMapper::toDomain).toList())
                .description(e.getDescription())
                .build();
    }
    public ParkTypeEntity toEntity(ParkType domain) {

        ParkTypeEntity entity = new ParkTypeEntity();
        entity.setId(domain.getId());
        entity.setType(domain.getType());

        if(domain.getParks() != null) {
            List<ParkEntity> parkEntities = domain.getParks().stream()
                    .map(p -> {
                        ParkEntity pe = new ParkEntity();
                        pe.setId(p.getId());
                        pe.setName(p.getName());
//                        pe.setLocation(p.getLocation());
                        pe.setParkType(entity);
                        return pe;
                    })
                    .toList();
            entity.setParks(parkEntities);
        }
        return entity;
    }
}
