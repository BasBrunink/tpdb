package com.tpdb.domain.tpdbrestbackend.controllers.dto.park.newPark;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateParkResponse(
        UUID id
) {
}
