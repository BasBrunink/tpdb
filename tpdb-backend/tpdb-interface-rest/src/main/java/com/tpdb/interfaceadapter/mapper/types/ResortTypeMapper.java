package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.ResortType;
import com.tpdb.interfaceadapter.dto.types.resorttype.ResortTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class ResortTypeMapper {

    public ResortTypeResponse toResponse(ResortType input) {
        return ResortTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
