package com.tpdb.tpdbrestbackend.controllers.mapper.park;

import com.tpdb.domain.data.Park;
import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkResponse;
import com.tpdb.tpdbrestbackend.controllers.mapper.DtoMapper;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper implements DtoMapper<Park, ParkRequest, ParkResponse> {
    @Override
    public Park toDomain(ParkRequest req) {
        return Park.builder()
                .id(req.id())
                .name(req.name())
                .description(req.description())
                .parkType(req.parkType())
                .opening(req.opening())
                .closing(req.closing())
                .status(req.status())
                .address(req.address())
                .areaSize(req.areaSize())
                .build();
    }

    @Override
    public ParkResponse toResponse(Park d) {
        return ParkResponse.builder()
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
                .build();
    }
}
