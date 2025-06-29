package com.tpdb.domain.tpdbrestbackend.controllers.dto.park.newPark;

import com.tpdb.domain.Park;
import com.tpdb.domain.enums.ParkStatus;
import com.tpdb.domain.enums.types.ParkType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateNewParkRequest(
        @NotBlank
        @NotNull
        String name,

        String description,

        ParkType parkType,
        LocalDate openingsDate,
        LocalDate closingDate,
        ParkStatus status,
        String address,
        double areaSize

) {
}
