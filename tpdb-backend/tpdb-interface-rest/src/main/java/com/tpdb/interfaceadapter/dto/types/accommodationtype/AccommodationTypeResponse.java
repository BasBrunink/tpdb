package com.tpdb.interfaceadapter.dto.types.accommodationtype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AccommodationTypeResponse(
        UUID id,
        String type,
        String description
) {
}
