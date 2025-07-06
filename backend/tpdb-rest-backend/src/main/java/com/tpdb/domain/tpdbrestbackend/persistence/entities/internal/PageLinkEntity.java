package com.tpdb.domain.tpdbrestbackend.persistence.entities.internal;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pageLink")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PageLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDateTime lastParse;
    private String link;
    @Enumerated(EnumType.STRING)
    private ScrapeSource source;
    private String url;
    @Enumerated(EnumType.STRING)
    private LinkType type;
    private String sourceID;


}
