package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.RideType;
import com.tpdb.interfaceadapter.dto.types.ridetype.RideTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class RideTypeMapper {

    public RideTypeResponse toResponse(RideType input) {
        return RideTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
