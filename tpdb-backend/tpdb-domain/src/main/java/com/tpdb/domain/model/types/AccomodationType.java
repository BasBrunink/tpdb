package com.tpdb.domain.model.types;

import com.tpdb.domain.model.Park;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccomodationType {
    private UUID id;
    private String type;
    private String description;
}
