package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.RestaurantType;
import com.tpdb.interfaceadapter.dto.types.restauranttype.RestaurantTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class RestaurantTypeMapper {
    public RestaurantTypeResponse toResponse(RestaurantType input) {
        return RestaurantTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
