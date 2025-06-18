package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.ShopType;
import com.tpdb.interfaceadapter.dto.types.shoptype.ShopTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class ShopTypeMapper {

    public ShopTypeResponse toResponse(ShopType input) {
        return ShopTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
