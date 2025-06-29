package com.tpdb.domain;

import com.tpdb.domain.enums.ParkStatus;
import com.tpdb.domain.enums.types.ParkType;
import com.tpdb.domain.user.User;
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
    private LocalDateTime created;
    private LocalDateTime updated;
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

}
