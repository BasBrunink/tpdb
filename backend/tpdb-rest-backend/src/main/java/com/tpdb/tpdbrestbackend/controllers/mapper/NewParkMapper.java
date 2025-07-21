package com.tpdb.tpdbrestbackend.controllers.mapper;

import com.tpdb.domain.data.Park;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateNewParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateParkResponse;
import org.springframework.stereotype.Component;

@Component
public class NewParkMapper implements DtoMapper<Park, CreateNewParkRequest, CreateParkResponse> {

    @Override
    public Park toDomain(CreateNewParkRequest req) {
        return Park.builder()
                .name(req.name())
                .description(req.description())
                .parkType(req.parkType())
                .opening(req.openingsDate())
                .closing(req.closingDate())
                .status(req.status())
                .address(req.address())
                .areaSize(req.areaSize())
                .build();
    }

    @Override
    public CreateParkResponse toResponse(Park domain) {
        return CreateParkResponse.builder()
                .id(domain.getId()).build();
    }
}
