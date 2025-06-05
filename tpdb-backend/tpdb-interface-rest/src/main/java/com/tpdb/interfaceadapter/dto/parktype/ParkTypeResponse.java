package com.tpdb.interfaceadapter.dto.parktype;

import lombok.Builder;

import java.util.UUID;
@Builder
public record ParkTypeResponse(
        UUID id,
        String type,
        String description
) {
}
