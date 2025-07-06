package com.tpdb.domain.tpdbrestbackend.persistence.mapper.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.EntityMapper;

public class PageLinkMapper implements EntityMapper<PageLink, PageLinkEntity> {
    @Override
    public PageLinkEntity toEntity(PageLink d) {
        return PageLinkEntity.builder()
                .id(d.getId())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .lastParse(d.getLastParse())
                .link(d.getLink())
                .source(d.getSource())
                .url(d.getUrl())
                .type(d.getType())
                .sourceID(d.getSourceID())
                .build();
    }

    @Override
    public PageLink toDomain(PageLinkEntity d) {
        return PageLink.builder()
                .id(d.getId())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .lastParse(d.getLastParse())
                .link(d.getLink())
                .source(d.getSource())
                .url(d.getUrl())
                .type(d.getType())
                .sourceID(d.getSourceID())
                .build();
    }
}
