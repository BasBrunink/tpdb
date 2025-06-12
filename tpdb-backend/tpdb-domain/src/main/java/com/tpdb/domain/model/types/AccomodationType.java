package com.tpdb.domain.model.types;

import lombok.*;

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
