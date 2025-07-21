package com.tpdb.tpdbrestbackend.persistence.mapper.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.entities.data.ParkEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("ParkEntityMapper")
class ParkEntityMapperTests {

    private final ParkEntityMapper mapper = new ParkEntityMapper();

    private final LocalDate opening = LocalDate.of(2020, 1, 1);
    private final LocalDate closing = LocalDate.of(2025, 1, 1);


    @Test
    void mapsDomainToEntityWithAllFieldsSet() {

        Park domain = Park.builder()
                .id(UUID.fromString("281dfc41-ecce-4ccd-89ff-d7af23aef463"))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .name("Central Park")
                .description("A large city park")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("123 Park Ave")
                .areaSize(100.5)
                .source(ScrapeSource.COASTERCLOUD)
                .sourceId("CP001")
                .build();

        ParkEntity entity = mapper.toEntity(domain);

        assertThat(entity.getId()).isEqualTo(domain.getId());
        assertThat(entity.getCreated()).isEqualTo(domain.getCreatedAt());
        assertThat(entity.getUpdated()).isEqualTo(domain.getUpdatedAt());
        assertThat(entity.getName()).isEqualTo(domain.getName());
        assertThat(entity.getDescription()).isEqualTo(domain.getDescription());
        assertThat(entity.getParkType()).isEqualTo(domain.getParkType());
        assertThat(entity.getOpening()).isEqualTo(domain.getOpening());
        assertThat(entity.getClosing()).isEqualTo(domain.getClosing());
        assertThat(entity.getStatus()).isEqualTo(domain.getStatus());
        assertThat(entity.getAddress()).isEqualTo(domain.getAddress());
        assertThat(entity.getAreaSize()).isEqualTo(domain.getAreaSize());
        assertThat(entity.getSource()).isEqualTo(domain.getSource());
        assertThat(entity.getSourceId()).isEqualTo(domain.getSourceId());
    }

    @Test
    void mapsEntityToDomainWithAllFieldsSet() {
        ParkEntity entity = ParkEntity.builder()
                .id(UUID.fromString("281dfc41-ecce-4ccd-89ff-d7af23aef463"))
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .name("Liberty Park")
                .description("A riverside park")
                .parkType(ParkType.AMUSEMENTPARK)
                .opening(opening)
                .closing(closing)
                .status(ParkStatus.OPERATING)
                .address("456 River Rd")
                .areaSize(200.0)
                .source(ScrapeSource.COASTERCLOUD)
                .sourceId("LP002")
                .build();

        Park domain = mapper.toDomain(entity);

        assertThat(domain.getId()).isEqualTo(entity.getId());
        assertThat(domain.getCreatedAt()).isEqualTo(entity.getCreated());
        assertThat(domain.getUpdatedAt()).isEqualTo(entity.getUpdated());
        assertThat(domain.getName()).isEqualTo(entity.getName());
        assertThat(domain.getDescription()).isEqualTo(entity.getDescription());
        assertThat(domain.getParkType()).isEqualTo(entity.getParkType());
        assertThat(domain.getOpening()).isEqualTo(entity.getOpening());
        assertThat(domain.getClosing()).isEqualTo(entity.getClosing());
        assertThat(domain.getStatus()).isEqualTo(entity.getStatus());
        assertThat(domain.getAddress()).isEqualTo(entity.getAddress());
        assertThat(domain.getAreaSize()).isEqualTo(entity.getAreaSize());
        assertThat(domain.getSource()).isEqualTo(entity.getSource());
        assertThat(domain.getSourceId()).isEqualTo(entity.getSourceId());
    }

    @Test
    void mapsDomainToEntityWithNullFields() {
        Park domain = Park.builder().build();

        ParkEntity entity = mapper.toEntity(domain);

        assertThat(entity.getId()).isNull();
        assertThat(entity.getCreated()).isNull();
        assertThat(entity.getUpdated()).isNull();
        assertThat(entity.getName()).isNull();
        assertThat(entity.getDescription()).isNull();
        assertThat(entity.getParkType()).isNull();
        assertThat(entity.getOpening()).isNull();
        assertThat(entity.getClosing()).isNull();
        assertThat(entity.getStatus()).isNull();
        assertThat(entity.getAddress()).isNull();
        assertThat(entity.getSource()).isNull();
        assertThat(entity.getSourceId()).isNull();
    }

    @Test
    void mapsEntityToDomainWithNullFields() {
        ParkEntity entity = ParkEntity.builder().build();

        Park domain = mapper.toDomain(entity);

        assertThat(domain.getId()).isNull();
        assertThat(domain.getCreatedAt()).isNull();
        assertThat(domain.getUpdatedAt()).isNull();
        assertThat(domain.getName()).isNull();
        assertThat(domain.getDescription()).isNull();
        assertThat(domain.getParkType()).isNull();
        assertThat(domain.getOpening()).isNull();
        assertThat(domain.getClosing()).isNull();
        assertThat(domain.getStatus()).isNull();
        assertThat(domain.getAddress()).isNull();
        assertThat(domain.getSource()).isNull();
        assertThat(domain.getSourceId()).isNull();
    }
}
