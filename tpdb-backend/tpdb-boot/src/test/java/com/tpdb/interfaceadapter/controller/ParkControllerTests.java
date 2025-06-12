package com.tpdb.interfaceadapter.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpdb.TestWebApp;
import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.domain.model.Park;
import com.tpdb.interfaceadapter.dto.park.CreateParkRequest;
import com.tpdb.interfaceadapter.dto.park.ParkResponse;
import com.tpdb.interfaceadapter.mapper.ParkMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ParkController.class)
@ContextConfiguration(classes = TestWebApp.class)
class ParkControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkUseCase parkUseCase;

    @MockBean
    private ParkMapper parkMapper;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void createPark_ShouldReturnParkResponse() throws Exception {
        CreateParkRequest request = CreateParkRequest.builder()
                .name("test")
                .location("test")
                .build();
        ParkResponse response = ParkResponse.builder()
                .name("test")
                .location("test")
                .build();

        Mockito.when(parkUseCase.create(request.name(), null, request.location()))
                .thenReturn(Park.builder()
                        .name("test").location("test").build());
        Mockito.when(parkMapper.toResponse(any(Park.class))).thenReturn(response);

        mockMvc.perform(post("/parks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.location").value("test"));

    }
    @Test
    void getAllParks_shouldReturnListOfParks() throws Exception {
        Park park = new Park(); // set fields if needed
        Mockito.when(parkUseCase.list()).thenReturn(List.of(park));

        mockMvc.perform(get("/parks"))
                .andExpect(status().isOk());
        // You can add more JSON assertions based on Park fields if necessary
    }




}