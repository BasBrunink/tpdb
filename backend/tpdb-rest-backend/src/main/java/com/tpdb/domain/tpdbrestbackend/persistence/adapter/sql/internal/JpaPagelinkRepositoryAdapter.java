package com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JpaPagelinkRepositoryAdapter implements PagelinkRepository {
    @Override
    public PageLink save(PageLink park) {
        return null;
    }

    @Override
    public Optional<PageLink> findyById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<PageLink> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }
}
