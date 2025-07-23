package com.tpdb.tpdbrestbackend.controllers.mapper;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateNewParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateParkResponse;
import com.tpdb.tpdbrestbackend.controllers.mapper.park.NewParkMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewParkMapperTests {

    private final NewParkMapper mapper = new NewParkMapper();

    @Test
    @DisplayName("toDomain maps all fields from CreateNewParkRequest to Park")
    void toDomainMapsAllFieldsCorrectly() {
        LocalDate opening = LocalDate.of(2020, 1,1 );
        LocalDate closing = LocalDate.of(2025, 1,1 );
        CreateNewParkRequest req = CreateNewParkRequest.builder()
                .name("testPark")
                .description("test ParkDescription")
                .parkType(ParkType.AMUSEMENTPARK)
                .openingsDate(opening)
                .closingDate(closing)
                .status(ParkStatus.OPERATING)
                .address("test address")
                .areaSize(100L)
                .build();

        Park park = mapper.toDomain(req);

        assertEquals("testPark", park.getName());
        assertEquals("test ParkDescription", park.getDescription());
        assertEquals(ParkType.AMUSEMENTPARK, park.getParkType());
        assertEquals(opening, park.getOpening());
        assertEquals(closing, park.getClosing());
        assertEquals(ParkStatus.OPERATING, park.getStatus());
        assertEquals("test address", park.getAddress());
        assertEquals(100L, park.getAreaSize());
    }

    @Test
    @DisplayName("toDomain handles null CreateNewParkRequest")
    void toDomainHandlesNullRequest() {
        assertThrows(NullPointerException.class, () -> mapper.toDomain(null));
    }

    @Test
    @DisplayName("toDomain handles missing optional fields")
    void toDomainHandlesMissingOptionalFields() {
        CreateNewParkRequest req = CreateNewParkRequest.builder()
                .name(null)
                .description(null)
                .parkType(null)
                .openingsDate(null)
                .closingDate(null)
                .status(null)
                .address(null)
                .build();

        Park park = mapper.toDomain(req);

        assertNull(park.getName());
        assertNull(park.getDescription());
        assertNull(park.getParkType());
        assertNull(park.getOpening());
        assertNull(park.getClosing());
        assertNull(park.getStatus());
        assertNull(park.getAddress());
    }

    @Test
    @DisplayName("toResponse maps Park id to CreateParkResponse")
    void toResponseMapsIdCorrectly() {
        Park park = Park.builder().id(UUID.fromString("b6741545-eaa0-49a1-9ed5-4b7c79787c2e")).build();

        CreateParkResponse response = mapper.toResponse(park);

        assertEquals(UUID.fromString("b6741545-eaa0-49a1-9ed5-4b7c79787c2e"), response.id());
    }

    @Test
    @DisplayName("toResponse handles null Park")
    void toResponseHandlesNullDomain() {
        assertThrows(NullPointerException.class, () -> mapper.toResponse(null));
    }

    @Test
    @DisplayName("toResponse handles Park with null id")
    void toResponseHandlesNullId() {
        Park park = Park.builder().id(null).build();

        CreateParkResponse response = mapper.toResponse(park);

        assertNull(response.id());
    }
}
