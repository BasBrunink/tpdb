package com.tpdb.interfaceadapter.dto.types.statustype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record StatusTypeResponse(
        UUID id,
        String type,
        String description
) {
}
