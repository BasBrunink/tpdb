package com.tpdb.interfaceadapter.mapper;

import com.tpdb.domain.model.Park;
import com.tpdb.interfaceadapter.dto.park.ParkResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkMapper {

    public ParkResponse toResponse(Park park) {
        return ParkResponse.builder()
                .id(park.getId())
                .name(park.getName())
//                .location(park.getLocation())
                .build();
    }


}
