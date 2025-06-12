package com.tpdb.interfaceadapter.dto.park;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateParkRequest(
        String name,
        String location,
        UUID parkTypeId
) {
}
