package com.tpdb.tpdbrestbackend.persistence.mapper.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PageLinkEntityMapper")
class PageLinkEntityMapperTests {

    private final LocalDateTime created = LocalDateTime.of(2020, 1, 1, 12, 1);
    private final LocalDateTime updated = LocalDateTime.of(2020, 1, 1, 12, 1);
    private final LocalDateTime lastParse = LocalDateTime.of(2020, 1, 1, 12, 1);

    private final PageLinkEntityMapper mapper = new PageLinkEntityMapper();

    @Test
    void mapsDomainToEntityWithAllFieldsSet() {
        PageLink domain = PageLink.builder()
                .id(UUID.fromString("6f4b0c89-5645-4747-8067-46288e4a2d29"))
                .createdAt(created)
                .updatedAt(updated)
                .lastParse(lastParse)
                .link("https://example.com/page")
                .source(ScrapeSource.COASTERCLOUD)
                .type(LinkType.PARK)
                .sourceID("SRC123")
                .build();

        PageLinkEntity entity = mapper.toEntity(domain);

        assertThat(entity.getId()).isEqualTo(domain.getId());
        assertThat(entity.getCreatedAt()).isEqualTo(domain.getCreatedAt());
        assertThat(entity.getUpdatedAt()).isEqualTo(domain.getUpdatedAt());
        assertThat(entity.getLastParse()).isEqualTo(domain.getLastParse());
        assertThat(entity.getLink()).isEqualTo(domain.getLink());
        assertThat(entity.getSource()).isEqualTo(domain.getSource());
        assertThat(entity.getType()).isEqualTo(domain.getType());
        assertThat(entity.getSourceID()).isEqualTo(domain.getSourceID());
    }

    @Test
    void mapsEntityToDomainWithAllFieldsSet() {
        PageLinkEntity entity = PageLinkEntity.builder()
                .id(UUID.fromString("6f4b0c89-5645-4747-8067-46288e4a2d29"))
                .createdAt(created)
                .updatedAt(updated)
                .lastParse(lastParse)
                .link("https://example.com/other")
                .source(ScrapeSource.COASTERCLOUD)
                .type(LinkType.PARK)
                .sourceID("SRC456")
                .build();

        PageLink domain = mapper.toDomain(entity);

        assertThat(domain.getId()).isEqualTo(entity.getId());
        assertThat(domain.getCreatedAt()).isEqualTo(entity.getCreatedAt());
        assertThat(domain.getUpdatedAt()).isEqualTo(entity.getUpdatedAt());
        assertThat(domain.getLastParse()).isEqualTo(entity.getLastParse());
        assertThat(domain.getLink()).isEqualTo(entity.getLink());
        assertThat(domain.getSource()).isEqualTo(entity.getSource());
        assertThat(domain.getType()).isEqualTo(entity.getType());
        assertThat(domain.getSourceID()).isEqualTo(entity.getSourceID());
    }

    @Test
    void mapsDomainToEntityWithNullFields() {
        PageLink domain = PageLink.builder().build();

        PageLinkEntity entity = mapper.toEntity(domain);

        assertThat(entity.getId()).isNull();
        assertThat(entity.getCreatedAt()).isNull();
        assertThat(entity.getUpdatedAt()).isNull();
        assertThat(entity.getLastParse()).isNull();
        assertThat(entity.getLink()).isNull();
        assertThat(entity.getSource()).isNull();
        assertThat(entity.getType()).isNull();
        assertThat(entity.getSourceID()).isNull();
    }

    @Test
    void mapsEntityToDomainWithNullFields() {
        PageLinkEntity entity = PageLinkEntity.builder().build();

        PageLink domain = mapper.toDomain(entity);

        assertThat(domain.getId()).isNull();
        assertThat(domain.getCreatedAt()).isNull();
        assertThat(domain.getUpdatedAt()).isNull();
        assertThat(domain.getLastParse()).isNull();
        assertThat(domain.getLink()).isNull();
        assertThat(domain.getSource()).isNull();
        assertThat(domain.getType()).isNull();
        assertThat(domain.getSourceID()).isNull();
    }
}