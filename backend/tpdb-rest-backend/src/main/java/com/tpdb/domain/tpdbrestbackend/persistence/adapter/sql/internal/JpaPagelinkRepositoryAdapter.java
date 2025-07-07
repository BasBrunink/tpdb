package com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.internal.JpaPageLinkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.internal.PageLinkEntityMapper;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class JpaPagelinkRepositoryAdapter implements PagelinkRepository {

    private final JpaPageLinkRepository pageLinkRepository;
    private final PageLinkEntityMapper pageLinkEntityMapper;

    @Override
    public PageLink save(PageLink pagelink) {
        return pageLinkEntityMapper.toDomain(
                pageLinkRepository.save(
                        pageLinkEntityMapper.toEntity(pagelink)
                )
        );
    }

    @Override
    public Optional<PageLink> findyById(UUID id) {
        return pageLinkRepository.findById(id).map(pageLinkEntityMapper::toDomain);
    }

    @Override
    public List<PageLink> findAll() {
        return pageLinkRepository.findAll().stream().map(pageLinkEntityMapper::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        pageLinkRepository.deleteById(id);

    }

    @Override
    public boolean existsById(UUID id) {
        return pageLinkRepository.existsById(id);
    }
}
