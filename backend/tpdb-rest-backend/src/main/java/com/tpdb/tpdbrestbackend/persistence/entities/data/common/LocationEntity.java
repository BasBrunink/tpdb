package com.tpdb.tpdbrestbackend.persistence.entities.data.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "location"

)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private UserEntity updatedBy;
//    private UserEntity createdBy;

    private String gps_long;
    private String gps_lat;
    private String country;
    private String city;
    private String street;

}
