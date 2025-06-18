package com.tpdb.infrastructure.repository.adapter.parser.coastercloud;

import com.tpdb.domain.model.parser.Pagelink;
import com.tpdb.domain.port.parser.coastercloud.PageLinkRepository;
import com.tpdb.infrastructure.repository.entity.parser.coastercloud.PageLinkEntity;
import com.tpdb.infrastructure.repository.jpa.parser.coastercloud.JpaPagelinkRepository;
import com.tpdb.infrastructure.repository.mapper.parser.coastercloud.PageLinkEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class PageLinkRepositoryAdapter implements PageLinkRepository {

    private final JpaPagelinkRepository pagelinkRepository;
    private final PageLinkEntityMapper pageLinkEntityMapper;

    @Override
    public Pagelink save(Pagelink pagelink) {
        return pageLinkEntityMapper.toDomain(pagelinkRepository.save(pageLinkEntityMapper.toEntity(pagelink)));
    }

    @Override
    public Optional<Pagelink> findById(UUID id) {
        return pagelinkRepository.findById(id).map(pageLinkEntityMapper::toDomain);
    }

    @Override
    public List<Pagelink> findAll() {
        return pagelinkRepository.findAll().stream().map(pageLinkEntityMapper::toDomain).toList();
    }
}
