package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.enums.ParkStatus;
import com.tpdb.domain.enums.types.ParkType;

import java.time.LocalDate;

public record ParkDto(
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
