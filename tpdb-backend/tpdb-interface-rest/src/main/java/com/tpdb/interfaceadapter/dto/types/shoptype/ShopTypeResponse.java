package com.tpdb.interfaceadapter.dto.types.shoptype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ShopTypeResponse(
        UUID id,
        String type,
        String description
) {
}
