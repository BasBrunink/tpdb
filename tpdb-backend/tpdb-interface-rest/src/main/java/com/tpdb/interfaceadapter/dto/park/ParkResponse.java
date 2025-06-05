package com.tpdb.interfaceadapter.dto.park;

import lombok.Builder;
import java.util.UUID;

@Builder
public record ParkResponse(
        UUID id,
        String name,
        String location
) {
}
