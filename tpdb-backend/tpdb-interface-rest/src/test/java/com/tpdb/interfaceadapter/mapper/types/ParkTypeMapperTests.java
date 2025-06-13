package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.ParkType;
import com.tpdb.interfaceadapter.dto.parktype.ParkTypeResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ParkTypeMapperTests {



    @Test
    void toResponse() {

        ParkTypeMapper parkTypeMapper = new ParkTypeMapper();

        ParkType input = ParkType.builder()
                .type("test")
                .description("test")
                .build();
        ParkTypeResponse response =  parkTypeMapper.toResponse(input);

        assertThat(response.type()).isEqualTo(input.getType());
        assertThat(response.description()).isEqualTo(input.getDescription());



    }


}
