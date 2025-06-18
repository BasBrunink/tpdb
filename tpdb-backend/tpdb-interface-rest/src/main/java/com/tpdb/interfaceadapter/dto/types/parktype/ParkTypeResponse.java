package com.tpdb.interfaceadapter.dto.types.parktype;

import lombok.Builder;

import java.util.UUID;
@Builder
public record ParkTypeResponse(
        UUID id,
        String type,
        String description
) {
}
