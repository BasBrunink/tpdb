package com.tpdb.domain.model.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    private String longitude;
    private String latitude;
    private String street;
    private String number;
    private String postcode;
    private String city;
    private String country;
}
