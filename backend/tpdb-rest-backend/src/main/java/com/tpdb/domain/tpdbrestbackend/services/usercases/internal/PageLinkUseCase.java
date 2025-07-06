package com.tpdb.domain.tpdbrestbackend.services.usercases.internal;

import com.tpdb.domain.internal.scraper.PageLink;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageLinkUseCase {

    PageLink create(PageLink request);
    Optional<PageLink> findById(UUID id);
    List<PageLink> findAll();
    PageLink update(UUID id, PageLink updatedPageLink);
    void delete(UUID id);
}
