package com.tpdb.interfaceadapter.dto.types.resorttype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ResortTypeResponse(
        UUID id,
        String type,
        String description
) {
}
