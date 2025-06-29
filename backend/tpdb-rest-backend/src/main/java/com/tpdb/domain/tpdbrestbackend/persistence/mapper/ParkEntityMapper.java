package com.tpdb.domain.tpdbrestbackend.persistence.mapper;

import com.tpdb.domain.Park;
import com.tpdb.domain.tpdbrestbackend.persistence.entities.ParkEntity;
import com.tpdb.domain.tpdbrestbackend.persistence.interfaces.EntityMapper;

public class ParkEntityMapper implements EntityMapper<Park, ParkEntity> {
    @Override
    public ParkEntity toEntity(Park d) {
        return ParkEntity.builder()
                .id(d.getId())
                .created(d.getCreated())
                .updated(d.getUpdated())
                .name(d.getName())
                .description(d.getDescription())
                .parkType(d.getParkType())
                .opening(d.getOpening())
                .closing(d.getClosing())
                .status(d.getStatus())
                .address(d.getAddress())
                .areaSize(d.getAreaSize())
                .build();
    }

    @Override
    public Park toDomain(ParkEntity e) {
        return Park.builder()
                .id(e.getId())
                .created(e.getCreated())
                .updated(e.getUpdated())
                .name(e.getName())
                .description(e.getDescription())
                .parkType(e.getParkType())
                .opening(e.getOpening())
                .closing(e.getClosing())
                .status(e.getStatus())
                .address(e.getAddress())
                .areaSize(e.getAreaSize())
                .build();
    }
}
