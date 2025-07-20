package com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Builder
public record UpdateParkResponse(
        UUID id,
        LocalDateTime created,
        LocalDateTime updated,
//         User updatedBy, //TODO: when we have spring security
//         User createdBy,

        String name,
        String description,
        ParkType parkType,
        LocalDate opening,
        LocalDate closing,
        ParkStatus status,
        String address,
        double areaSize
) {
}
