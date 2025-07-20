package com.tpdb.tpdbrestbackend.persistence.repositories.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PagelinkRepository {
    PageLink save(PageLink pagelink);
    Optional<PageLink> findyById(UUID id);
    List<PageLink> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);

    List<PageLink> findTopNByTypeAndParseDue(LinkType type, LocalDateTime cutoff, int batchSize);

    Optional<PageLink> findByLink(String link);
}
