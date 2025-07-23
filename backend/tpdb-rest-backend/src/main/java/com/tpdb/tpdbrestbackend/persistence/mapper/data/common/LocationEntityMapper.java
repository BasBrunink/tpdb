package com.tpdb.tpdbrestbackend.persistence.mapper.data.common;

import com.tpdb.domain.data.common.Location;
import com.tpdb.tpdbrestbackend.persistence.entities.data.common.LocationEntity;
import com.tpdb.tpdbrestbackend.persistence.mapper.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationEntityMapper implements EntityMapper<Location, LocationEntity> {
    @Override
    public LocationEntity toEntity(Location domain) {
        return LocationEntity.builder()
                .id(domain.getId())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .gps_lat(domain.getGps_lat())
                .gps_long(domain.getGps_long())
                .country(domain.getCountry())
                .city(domain.getCity())
                .street(domain.getStreet())
                .build();
    }

    @Override
    public Location toDomain(LocationEntity entity) {
        return Location.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .gps_lat(entity.getGps_lat())
                .gps_long(entity.getGps_long())
                .country(entity.getCountry())
                .city(entity.getCity())
                .street(entity.getStreet())
                .build();
    }
}
