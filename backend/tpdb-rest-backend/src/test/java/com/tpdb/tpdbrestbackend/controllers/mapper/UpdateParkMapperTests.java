package com.tpdb.tpdbrestbackend.controllers.mapper;


import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.tpdb.domain.data.Park;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkResponse;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class UpdateParkMapperTests {

    private final UpdateParkMapper mapper = new UpdateParkMapper();
    private final LocalDate opening = LocalDate.of(2020, 1, 1);
    private final LocalDate closing = LocalDate.of(2025, 1, 1);
    @Test
    @DisplayName("toDomain maps all fields from UpdateParkRequest to Park")
    void toDomainMapsAllFieldsCorrectly() {

        UpdateParkRequest req = UpdateParkRequest.builder()
                .name("Green Park")
                .description("A beautiful green park")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("456 Park Ave")
                .areaSize(250.0)
                .build();

        Park park = mapper.toDomain(req);

        assertEquals("Green Park", park.getName());
        assertEquals("A beautiful green park", park.getDescription());
        assertEquals(ParkType.AMUSEMENTPARK, park.getParkType());
        assertEquals(opening, park.getOpening());
        assertEquals(closing, park.getClosing());
        assertEquals(ParkStatus.OPERATING, park.getStatus());
        assertEquals("456 Park Ave", park.getAddress());
        assertEquals(250.0, park.getAreaSize());
    }

    @Test
    @DisplayName("toDomain handles null UpdateParkRequest")
    void toDomainHandlesNullRequest() {
        assertThrows(NullPointerException.class, () -> mapper.toDomain(null));
    }

    @Test
    @DisplayName("toDomain handles missing optional fields")
    void toDomainHandlesMissingOptionalFields() {
        UpdateParkRequest req = UpdateParkRequest.builder()
                .name(null)
                .description(null)
                .parkType(null)
                .opening(null)
                .closing(null)
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
    @DisplayName("toResponse maps all fields from Park to UpdateParkResponse")
    void toResponseMapsAllFieldsCorrectly() {
        Park park = Park.builder()
                .name("Blue Park")
                .description("A park with lakes")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("789 Lake Rd")
                .areaSize(500.0)
                .build();

        UpdateParkResponse response = mapper.toResponse(park);

        assertEquals("Blue Park", response.name());
        assertEquals("A park with lakes", response.description());
        assertEquals(ParkType.AMUSEMENTPARK, response.parkType());
        assertEquals(opening, response.opening());
        assertEquals(closing, response.closing());
        assertEquals(ParkStatus.OPERATING, response.status());
        assertEquals("789 Lake Rd", response.address());
        assertEquals(500.0, response.areaSize());
    }

    @Test
    @DisplayName("toResponse handles null Park")
    void toResponseHandlesNullDomain() {
        assertThrows(NullPointerException.class, () -> mapper.toResponse(null));
    }

    @Test
    @DisplayName("toResponse handles Park with missing optional fields")
    void toResponseHandlesMissingOptionalFields() {
        Park park = Park.builder()
                .name(null)
                .description(null)
                .parkType(null)
                .opening(null)
                .closing(null)
                .status(null)
                .address(null)
                .build();

        UpdateParkResponse response = mapper.toResponse(park);

        assertNull(response.name());
        assertNull(response.description());
        assertNull(response.parkType());
        assertNull(response.opening());
        assertNull(response.closing());
        assertNull(response.status());
        assertNull(response.address());

    }
}