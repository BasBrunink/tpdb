package com.tpdb.domain.tpdbrestbackend.services.implementation.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.tpdbrestbackend.services.usercases.internal.PageLinkUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PageLinkService implements PageLinkUseCase {
    @Override
    public PageLink create(PageLink request) {
        return null;
    }

    @Override
    public Optional<PageLink> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<PageLink> findAll() {
        return List.of();
    }

    @Override
    public PageLink update(UUID id, PageLink updatedPageLink) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
