package com.tpdb.domain.tpdbrestbackend.services.usercases.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageLinkUseCase {

    PageLink create(PageLink request);

    //TODO: ParkLinks are now identified by the url / link and we need this to be ID.
    Optional<PageLink> findById(UUID id);
    Optional<PageLink> findByLink(String link);

    //TODO: Up for deletion, we might not need this in production
    List<PageLink> findAll();
    void update(UUID id, PageLink updatedPageLink);
    void delete(UUID id);

    List<PageLink> findNextBatchToParse(LinkType type, int batchSize);
}
