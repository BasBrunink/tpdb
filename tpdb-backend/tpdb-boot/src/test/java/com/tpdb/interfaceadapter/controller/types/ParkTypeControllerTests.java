package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.TestWebApp;
import com.tpdb.application.port.in.data.types.ParkTypeUseCase;
import com.tpdb.domain.model.types.ParkType;
import com.tpdb.interfaceadapter.dto.parktype.ParkTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.ParkTypeMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(ParkTypeController.class)
@ContextConfiguration(classes = TestWebApp.class)
public class ParkTypeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkTypeUseCase parkTypeUseCase;

    @MockBean
    private ParkTypeMapper parkTypeMapper;


    @Test
    void getParkTypeById_shouldReturnResponseIfFound() throws Exception {
        UUID id = UUID.randomUUID();


        ParkType domain = ParkType.builder()
                .id(id)
                .type("test")
                .description("test")
                .build();
        ParkTypeResponse dto = ParkTypeResponse.builder()
                .id(id)
                .type("test")
                .description("test")
                .build();

        Mockito.when(parkTypeUseCase.findById(eq(id))).thenReturn(Optional.of(domain));
        Mockito.when(parkTypeMapper.toResponse(eq(domain))).thenReturn(dto);

        mockMvc.perform(get("/park-types/by-id/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.type").value("test"));
    }

    @Test
    void getParkTypeById_shouldReturnNotFoundIfMissing() throws Exception {
        UUID id = UUID.randomUUID();

        Mockito.when(parkTypeUseCase.findById(eq(id))).thenReturn(Optional.empty());

        mockMvc.perform(get("/park-types/by-id/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    void getParkTypeByType_shouldReturnResponseIfFound() throws Exception {
        UUID id = UUID.randomUUID();

        String type = "test";

        ParkType domain = ParkType.builder()
                .id(id)
                .type("test")
                .description("test")
                .build();
        ParkTypeResponse dto = ParkTypeResponse.builder()
                .id(id)
                .type("test")
                .description("test")
                .build();

        Mockito.when(parkTypeUseCase.findByType(eq(type))).thenReturn(Optional.of(domain));
        Mockito.when(parkTypeMapper.toResponse(eq(domain))).thenReturn(dto);

        mockMvc.perform(get("/park-types/by-type/" + type))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value(type));
    }

    @Test
    void getParkTypeByType_shouldReturnNotFoundIfMissing() throws Exception {
        Mockito.when(parkTypeUseCase.findByType(eq("Unknown"))).thenReturn(Optional.empty());

        mockMvc.perform(get("/park-types/by-type/Unknown"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAll_shouldReturnListOfParkTypes() throws Exception {

        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        ParkType domain1 = ParkType.builder()
                .id(id1)
                .type("test1")
                .description("test1")
                .build();
        ParkTypeResponse dto1 = ParkTypeResponse.builder()
                .id(id1)
                .type("test1")
                .description("test1")
                .build();

        ParkType domain2 = ParkType.builder()
                .id(id2)
                .type("test2")
                .description("test2")
                .build();
        ParkTypeResponse dto2 = ParkTypeResponse.builder()
                .id(id2)
                .type("test2")
                .description("test2")
                .build();


        Mockito.when(parkTypeUseCase.findAll()).thenReturn(List.of(domain1, domain2));
        Mockito.when(parkTypeMapper.toResponse(domain1)).thenReturn(dto1);
        Mockito.when(parkTypeMapper.toResponse(domain2)).thenReturn(dto2);

        mockMvc.perform(get("/park-types"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

}
