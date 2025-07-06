package com.tpdb.domain.tpdbrestbackend.controllers.dto.park;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;

import java.time.LocalDate;
import java.util.UUID;

public record ParkRequest(
        UUID id,
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
