package com.tpdb.domain.tpdbrestbackend.controllers.dto.park.updatePark;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;

import java.time.LocalDate;

public record UpdateParkRequest(
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
