package com.tpdb.tpdbrestbackend.persistence.mapper.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import com.tpdb.tpdbrestbackend.persistence.mapper.EntityMapper;
import org.springframework.stereotype.Component;

@Component
public class PageLinkEntityMapper implements EntityMapper<PageLink, PageLinkEntity> {
    @Override
    public PageLinkEntity toEntity(PageLink d) {
        return PageLinkEntity.builder()
                .id(d.getId())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .lastParse(d.getLastParse())
                .link(d.getLink())
                .source(d.getSource())

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
                .type(d.getType())
                .sourceID(d.getSourceID())
                .build();
    }
}
