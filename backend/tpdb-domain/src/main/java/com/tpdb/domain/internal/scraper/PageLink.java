package com.tpdb.domain.internal.scraper;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageLink {
    private UUID id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDateTime lastParse;
    private String link;
    private ScrapeSource source;
    private String url;
    private LinkType type;
    private String sourceID;
}
