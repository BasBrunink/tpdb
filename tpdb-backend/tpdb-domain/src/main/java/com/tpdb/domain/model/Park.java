package com.tpdb.domain.model;


import com.tpdb.domain.model.common.Location;
import com.tpdb.domain.model.common.Status;
import com.tpdb.domain.model.types.ParkType;
import lombok.*;

import java.util.List;
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
    private Location location;
    private List<Status> status;
}
