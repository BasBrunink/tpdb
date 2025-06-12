package com.tpdb.domain.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resort {
    private String name;
    private String description;
    private Company owner;
    private Company operator;
    private List<Accomodation> accomodations;
    private List<Park> parks;
    private List<Shop> shops;
    private List<Restaurant> restaurants;

}
