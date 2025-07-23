package com.tpdb.tpdbrestbackend.controllers.mapper;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkResponse;
import com.tpdb.tpdbrestbackend.controllers.mapper.park.ParkMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ParkMapperTests {
    private final ParkMapper mapper = new ParkMapper();
    @Test
    void toDomainMapsAllFieldsCorrectly() {
        LocalDate opening = LocalDate.of(2020, 1,1);
        LocalDate closing = LocalDate.of(2025, 1, 1);

        ParkRequest request = ParkRequest.builder()
                .name("testPark")
                .description("test ParkDescription")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("test address")
                .areaSize(100L)
                .build();
        Park park = mapper.toDomain(request);
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
    void toDomainHandlesNullRequest() {
        assertThrows(NullPointerException.class, () -> mapper.toDomain(null));
    }
    @Test
    void toDomainHandlesMissingOptionalFields() {
        ParkRequest req = ParkRequest.builder()
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
    void toResponseMapsFieldCorrectly() {
        LocalDate opening = LocalDate.of(2020, 1,1 );
        LocalDate closing = LocalDate.of(2025, 1,1 );
        Park park = Park.builder()
                .name("testPark")
                .description("test ParkDescription")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("test address")
                .areaSize(100L)
                .build();
        ParkResponse response = mapper.toResponse(park);

        assertEquals("testPark", response.name());
        assertEquals("test ParkDescription", response.description());
        assertEquals(ParkType.AMUSEMENTPARK, response.parkType());
        assertEquals(opening, response.opening());
        assertEquals(closing, response.closing());
        assertEquals(ParkStatus.OPERATING, response.status());
        assertEquals("test address", response.address());
        assertEquals(100L, response.areaSize());
    }

    @Test
    void toResponseHandlesNullRequests() {
        assertThrows(NullPointerException.class, () -> mapper.toDomain(null));
    }

    @Test
    void toResponseHandlesOptionalFields() {

        Park park = Park.builder()
                .name(null)
                .description(null)
                .parkType(null)
                .opening(null)
                .closing(null)
                .status(null)
                .address(null)
                .build();

        ParkResponse response = mapper.toResponse(park);
        assertNull(response.name());
        assertNull(response.description());
        assertNull(response.parkType());
        assertNull(response.opening());
        assertNull(response.closing());
        assertNull(response.status());
        assertNull(response.address());

    }

}
