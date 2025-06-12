package com.tpdb.domain.model;

import com.tpdb.domain.model.common.Location;
import com.tpdb.domain.model.types.AccommodationType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accomodation {
    private String name;
    private String description;
    private Location location;
    private Company owner;
    private Company operator;
    private AccommodationType accommodationType;
    private Integer numberOfRooms;

}
