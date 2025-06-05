package com.tpdb.domain.model;


import com.tpdb.domain.model.types.ParkType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Park {
    private UUID id;
    private String name;
    private ParkType parkType;
    private String location;
}
