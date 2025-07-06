package com.tpdb.domain.tpdbrestbackend.persistence.repositories.internal;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.PageLink;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PagelinkRepository {
    PageLink save(PageLink park);
    Optional<PageLink> findyById(UUID id);
    List<PageLink> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
