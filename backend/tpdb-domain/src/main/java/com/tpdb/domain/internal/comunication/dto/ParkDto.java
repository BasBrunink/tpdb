package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import lombok.Builder;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
public record ParkDto(
        String name,
        String description,
        ParkType parkType,
        LocalDate opening,
        LocalDate closing,
        ParkStatus status,
        String address,
        double areaSize,
        String sourceId,
        ScrapeSource source
) implements Serializable {
}
