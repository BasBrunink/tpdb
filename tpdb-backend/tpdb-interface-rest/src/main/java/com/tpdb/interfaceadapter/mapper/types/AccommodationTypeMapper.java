package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.AccommodationType;
import com.tpdb.interfaceadapter.dto.types.accommodationtype.AccommodationTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class AccommodationTypeMapper {

    public AccommodationTypeResponse toResponse(AccommodationType input) {
        return AccommodationTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
