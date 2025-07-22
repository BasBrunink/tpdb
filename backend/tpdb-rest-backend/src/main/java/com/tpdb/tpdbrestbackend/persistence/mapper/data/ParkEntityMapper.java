package com.tpdb.tpdbrestbackend.persistence.mapper.data;

import com.tpdb.domain.data.Park;
import com.tpdb.tpdbrestbackend.persistence.entities.data.ParkEntity;
import com.tpdb.tpdbrestbackend.persistence.mapper.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkEntityMapper implements EntityMapper<Park, ParkEntity> {
    @Override
    public ParkEntity toEntity(Park d) {
        return ParkEntity.builder()
                .id(d.getId())
                .created(d.getCreatedAt())
                .updated(d.getUpdatedAt())
                .name(d.getName())
                .description(d.getDescription())
                .parkType(d.getParkType())
                .opening(d.getOpening())
                .closing(d.getClosing())
                .status(d.getStatus())
                .address(d.getAddress())
                .areaSize(d.getAreaSize())
                .source(d.getSource())
                .sourceId(d.getSourceId())
                .build();
    }

    @Override
    public Park toDomain(ParkEntity e) {
        return Park.builder()
                .id(e.getId())
                .createdAt(e.getCreated())
                .updatedAt(e.getUpdated())
                .name(e.getName())
                .description(e.getDescription())
                .parkType(e.getParkType())
                .opening(e.getOpening())
                .closing(e.getClosing())
                .status(e.getStatus())
                .address(e.getAddress())
                .areaSize(e.getAreaSize())
                .source(e.getSource())
                .sourceId(e.getSourceId())
                .build();
    }
}
