package com.tpdb.tpdbrestbackend.controllers.controllers;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.UUID;
import java.util.Collections;
import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkResponse;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateNewParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateParkResponse;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkResponse;
import com.tpdb.domain.data.Park;
import com.tpdb.tpdbrestbackend.services.usecases.data.ParkUseCase;
import com.tpdb.tpdbrestbackend.controllers.mapper.park.NewParkMapper;
import com.tpdb.tpdbrestbackend.controllers.mapper.park.UpdateParkMapper;
import com.tpdb.tpdbrestbackend.controllers.mapper.park.ParkMapper;

class ParkControllerTests {

    private final ParkUseCase parkUseCase = mock(ParkUseCase.class);
    private final NewParkMapper newParkMapper = mock(NewParkMapper.class);
    private final UpdateParkMapper updateParkMapper = mock(UpdateParkMapper.class);
    private final ParkMapper parkMapper = mock(ParkMapper.class);
    private final ParkController controller = new ParkController(parkUseCase, newParkMapper, updateParkMapper, parkMapper);

    @Test
    @DisplayName("createPark returns response entity with created park")
    void createParkReturnsResponseEntityWithCreatedPark() {
        CreateNewParkRequest request = mock(CreateNewParkRequest.class);
        Park park = mock(Park.class);
        CreateParkResponse response = mock(CreateParkResponse.class);

        when(newParkMapper.toDomain(request)).thenReturn(park);
        when(parkUseCase.create(park)).thenReturn(park);
        when(newParkMapper.toResponse(park)).thenReturn(response);

        ResponseEntity<CreateParkResponse> result = controller.createPark(request);

        assertEquals(ResponseEntity.ok(response), result);
    }

    @Test
    @DisplayName("getAllParks returns paged park responses")
    void getAllParksReturnsPagedParkResponses() {
        Pageable pageable = mock(Pageable.class);
        Park park = mock(Park.class);
        ParkResponse parkResponse = mock(ParkResponse.class);
        Page<Park> parkPage = new PageImpl<>(Collections.singletonList(park));
        Page<ParkResponse> responsePage = new PageImpl<>(Collections.singletonList(parkResponse));

        when(parkUseCase.findAll(pageable)).thenReturn(parkPage);
        when(parkMapper.toResponse(park)).thenReturn(parkResponse);

        ResponseEntity<Page<ParkResponse>> result = controller.getAllParks(pageable);

        assertEquals(ResponseEntity.ok(responsePage), result);
    }

    @Test
    @DisplayName("getParkById returns park response when found")
    void getParkByIdReturnsParkResponseWhenFound() {
        UUID id = UUID.randomUUID();
        Park park = mock(Park.class);
        ParkResponse parkResponse = mock(ParkResponse.class);

        when(parkUseCase.findById(id)).thenReturn(Optional.of(park));
        when(parkMapper.toResponse(park)).thenReturn(parkResponse);

        ResponseEntity<ParkResponse> result = controller.getParkById(id.toString());

        assertEquals(ResponseEntity.ok(parkResponse), result);
    }

    @Test
    @DisplayName("getParkById returns not found when park does not exist")
    void getParkByIdReturnsNotFoundWhenParkDoesNotExist() {
        UUID id = UUID.randomUUID();

        when(parkUseCase.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<ParkResponse> result = controller.getParkById(id.toString());

        assertEquals(ResponseEntity.notFound().build(), result);
    }

    @Test
    @DisplayName("updatePark returns updated park response")
    void updateParkReturnsUpdatedParkResponse() {
        UUID id = UUID.randomUUID();
        UpdateParkRequest request = mock(UpdateParkRequest.class);
        Park park = mock(Park.class);
        UpdateParkResponse response = mock(UpdateParkResponse.class);

        when(updateParkMapper.toDomain(request)).thenReturn(park);
        when(parkUseCase.update(id, park)).thenReturn(park);
        when(updateParkMapper.toResponse(park)).thenReturn(response);

        ResponseEntity<UpdateParkResponse> result = controller.updatePark(id.toString(), request);

        assertEquals(ResponseEntity.ok(response), result);
    }

    @Test
    @DisplayName("deletePark returns no content response")
    void deleteParkReturnsNoContentResponse() {
        UUID id = UUID.randomUUID();

        ResponseEntity<Void> result = controller.deletePark(id.toString());

        assertEquals(ResponseEntity.noContent().build(), result);
        verify(parkUseCase).delete(id);
    }
}