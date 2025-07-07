package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;

import java.time.LocalDateTime;

public record PageLinkDto(
         LocalDateTime lastParse,
         String link,
         ScrapeSource source,
         String url,
         LinkType type,
         String sourceID
) {
}
