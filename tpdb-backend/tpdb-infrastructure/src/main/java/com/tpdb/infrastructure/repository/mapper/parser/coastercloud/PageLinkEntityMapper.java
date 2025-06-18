package com.tpdb.infrastructure.repository.mapper.parser.coastercloud;

import com.tpdb.domain.model.parser.Pagelink;
import com.tpdb.infrastructure.repository.entity.parser.coastercloud.PageLinkEntity;
import org.springframework.stereotype.Component;

@Component
public class PageLinkEntityMapper {

    public Pagelink toDomain(PageLinkEntity e) {
        return Pagelink.builder()
                .lastParse(e.getLastParse())
                .link(e.getLink())
                .sourceId(e.getSourceId())
                .source(e.getSource())
                .type(e.getType())
                .build();
    }
    public PageLinkEntity toEntity(Pagelink e) {
        return PageLinkEntity.builder()
                .lastParse(e.getLastParse())
                .link(e.getLink())
                .sourceId(e.getSourceId())
                .source(e.getSource())
                .type(e.getType())
                .build();
    }
}
