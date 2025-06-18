package com.tpdb.interfaceadapter.mapper;

import com.tpdb.domain.model.Park;
import com.tpdb.domain.model.types.ParkType;
import com.tpdb.interfaceadapter.dto.park.ParkResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParkMapperTests {


    @Test
    void test() {
        ParkMapper parkMapper = new ParkMapper();

        Park park = Park.builder()
                .name("test")
                .parkType(ParkType.builder().type("test").build())
//                .location("test")
                .build();
        ParkResponse response = parkMapper.toResponse(park);
        assertThat(response.name()).isEqualTo(park.getName());
        assertThat(response.location()).isEqualTo(park.getLocation());


    }
}
