package com.tpdb.domain.data.common;

import com.tpdb.domain.data.user.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User updatedBy; //TODO: when we have spring security
    private User createdBy;

    private String gps_long;
    private String gps_lat;
    private String country;
    private String city;
    private String street;

}
