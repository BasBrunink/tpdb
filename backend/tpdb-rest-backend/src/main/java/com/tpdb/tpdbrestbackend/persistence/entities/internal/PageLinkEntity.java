package com.tpdb.tpdbrestbackend.persistence.entities.internal;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "page_link")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PageLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastParse;
    private String link;
    @Enumerated(EnumType.STRING)
    private ScrapeSource source;
    private String url;
    @Enumerated(EnumType.STRING)
    private LinkType type;
    private String sourceID;


}
