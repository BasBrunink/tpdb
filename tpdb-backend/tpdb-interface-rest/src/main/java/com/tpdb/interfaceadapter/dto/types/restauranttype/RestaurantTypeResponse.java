package com.tpdb.interfaceadapter.dto.types.restauranttype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RestaurantTypeResponse(UUID id,
                                     String type,
                                     String description) {
}
