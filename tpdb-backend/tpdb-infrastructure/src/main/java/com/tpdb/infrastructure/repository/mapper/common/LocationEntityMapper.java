package com.tpdb.infrastructure.repository.mapper.common;

import com.tpdb.domain.model.common.Location;
import com.tpdb.infrastructure.repository.entity.common.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationEntityMapper {
    public Location toDomain(LocationEntity e) {
        return Location.builder()
                .longitude(e.getLongitude())
                .latitude(e.getLatitude())
                .street(e.getStreet())
                .number(e.getNumber())
                .postcode(e.getPostcode())
                .city(e.getCity())
                .country(e.getCountry())
                .build();
    }

    public LocationEntity toEntity(Location e) {
        return LocationEntity
                .builder()
                .longitude(e.getLongitude())
                .latitude(e.getLatitude())
                .street(e.getStreet())
                .number(e.getNumber())
                .postcode(e.getPostcode())
                .city(e.getCity())
                .country(e.getCountry()).build();
    }
}
