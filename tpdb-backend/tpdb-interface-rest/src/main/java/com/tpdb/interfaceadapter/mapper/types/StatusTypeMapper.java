package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.StatusType;
import com.tpdb.interfaceadapter.dto.types.statustype.StatusTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class StatusTypeMapper {

    public StatusTypeResponse toResponse(StatusType input) {
        return StatusTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
