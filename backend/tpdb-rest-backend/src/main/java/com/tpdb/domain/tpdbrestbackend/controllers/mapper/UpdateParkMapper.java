package com.tpdb.domain.tpdbrestbackend.controllers.mapper;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkRequest;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkResponse;
import org.springframework.stereotype.Component;

@Component
public class UpdateParkMapper implements DtoMapper<Park, UpdateParkRequest, UpdateParkResponse> {
    @Override
    public Park toDomain(UpdateParkRequest req) {
        return Park.builder()
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
    public UpdateParkResponse toResponse(Park domain) {
        return UpdateParkResponse.builder()
                .name(domain.getName())
                .description(domain.getDescription())
                .parkType(domain.getParkType())
                .opening(domain.getOpening())
                .closing(domain.getClosing())
                .status(domain.getStatus())
                .address(domain.getAddress())
                .areaSize(domain.getAreaSize())
                .build();
    }
}
