package com.tpdb.tpdbrestbackend.persistence.adapter.sql.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.tpdbrestbackend.persistence.jpa.internal.JpaPageLinkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.internal.PageLinkEntityMapper;
import com.tpdb.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
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
    public Optional<PageLink> findById(UUID id) {
        return pageLinkRepository.findById(id).map(pageLinkEntityMapper::toDomain);
    }

    @Override
    public Optional<PageLink> findByLink(String link) {
        return pageLinkRepository.findByLink(link).map(pageLinkEntityMapper::toDomain);
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

    @Override
    public List<PageLink> findTopNByTypeAndParseDue(LinkType type, LocalDateTime cutoff, int batchSize) {
        return pageLinkRepository.findNextBatch(type, cutoff, PageRequest.of(0, batchSize)).stream().map(pageLinkEntityMapper::toDomain).toList();

    }

}
