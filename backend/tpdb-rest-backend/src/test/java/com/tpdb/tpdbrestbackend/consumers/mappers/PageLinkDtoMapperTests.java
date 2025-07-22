package com.tpdb.tpdbrestbackend.consumers.mappers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PageLinkDtoMapperTests {
    private final PageLinkDtoMapper mapper = new PageLinkDtoMapper();

    @Test
    void toDto_mapsAllFieldsCorrectly() {
        PageLink pageLink = new PageLink();
        pageLink.setLastParse(LocalDateTime.of(2025,1,1,12,0));
        pageLink.setLink("http://example.com");
        pageLink.setSource(ScrapeSource.COASTERCLOUD);
        pageLink.setType(LinkType.PARK);
        pageLink.setSourceID("id");

        PageLinkDto dto = mapper.toDto(pageLink);

        assertThat(dto.lastParse()).isEqualTo(LocalDateTime.of(2025,1,1,12,0));
        assertThat(dto.link()).isEqualTo("http://example.com");
        assertThat(dto.source()).isEqualTo(ScrapeSource.COASTERCLOUD);
        assertThat(dto.type()).isEqualTo(LinkType.PARK);
        assertThat(dto.sourceID()).isEqualTo("id");
    }

    @Test
    void toDto_handlesNullFieldsGracefully() {
        PageLink pageLink = new PageLink();
        pageLink.setLastParse(null);
        pageLink.setLink(null);
        pageLink.setSource(null);
        pageLink.setType(null);
        pageLink.setSourceID(null);

        PageLinkDto dto = mapper.toDto(pageLink);

        assertThat(dto.lastParse()).isNull();
        assertThat(dto.link()).isNull();
        assertThat(dto.source()).isNull();
        assertThat(dto.type()).isNull();
        assertThat(dto.sourceID()).isNull();
    }
}
