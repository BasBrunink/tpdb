package com.tpdb.domain.data;

import com.tpdb.domain.data.common.Location;
import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.data.user.User;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Park {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User updatedBy; //TODO: when we have spring security
    private User createdBy;

    private String name;
    private String description;
    private ParkType parkType;
    private LocalDate opening;
    private LocalDate closing;
    private ParkStatus status;
    private String address;
    private double areaSize;
    private String sourceId;
    private ScrapeSource source;

    //Relations
    private Location location;

}
