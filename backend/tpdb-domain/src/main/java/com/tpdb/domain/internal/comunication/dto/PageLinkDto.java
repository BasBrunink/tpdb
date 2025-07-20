package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
public record PageLinkDto(
         LocalDateTime lastParse,
         String link,
         ScrapeSource source,
         LinkType type,
         String sourceID
) implements Serializable {
}
