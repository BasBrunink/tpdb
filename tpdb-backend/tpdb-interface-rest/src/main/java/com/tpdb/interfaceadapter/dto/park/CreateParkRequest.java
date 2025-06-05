package com.tpdb.interfaceadapter.dto.park;

import java.util.UUID;

public record CreateParkRequest(
        String name,
        String location,
        UUID parkTypeId
) {
}
