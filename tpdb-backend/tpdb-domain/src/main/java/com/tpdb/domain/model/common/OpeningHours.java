package com.tpdb.domain.model.common;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpeningHours {
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private LocalTime opening;
    private LocalTime closing;
}
