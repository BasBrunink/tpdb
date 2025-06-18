package com.tpdb.interfaceadapter.dto.types.ridetype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RideTypeResponse(
        UUID id,
        String type,
        String description

) {
}
