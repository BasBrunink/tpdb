package com.tpdb.infrastructure.repository.entity.common;


import com.tpdb.infrastructure.repository.entity.ParkEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "locations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationEntity {
    @Id
    private UUID id;
    private String longitude;
    private String latitude;
    private String street;
    private String number;
    private String postcode;
    private String city;
    private String country;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<ParkEntity> parks;

}

