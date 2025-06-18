package com.tpdb.domain.model.common;

import com.tpdb.domain.model.types.StatusType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Status {
    private boolean current;
    private LocalDate statusStart;
    private LocalDate statusEnd;
    private StatusType status;
}
