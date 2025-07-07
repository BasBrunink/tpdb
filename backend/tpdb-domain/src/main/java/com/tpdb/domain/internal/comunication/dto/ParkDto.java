package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;

import java.io.Serializable;
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
) implements Serializable {
}
