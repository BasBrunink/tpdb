package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.interfaceadapter.dto.types.parktype.ParkTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkTypeMapper {
    public ParkTypeResponse toResponse(ParkType parkType) {
        return ParkTypeResponse.builder()
                .id(parkType.getId())
                .type(parkType.getType())
                .description(parkType.getDescription())
                .build();
    }
}
