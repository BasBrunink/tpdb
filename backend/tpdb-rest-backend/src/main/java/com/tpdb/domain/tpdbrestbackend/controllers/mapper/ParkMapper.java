package com.tpdb.domain.tpdbrestbackend.controllers.mapper;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.ParkRequest;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.ParkResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper implements DtoMapper<Park, ParkRequest, ParkResponse> {
    @Override
    public Park toDomain(ParkRequest req) {
        return null;
    }

    @Override
    public ParkResponse toResponse(Park d) {
        return ParkResponse.builder()
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
}
