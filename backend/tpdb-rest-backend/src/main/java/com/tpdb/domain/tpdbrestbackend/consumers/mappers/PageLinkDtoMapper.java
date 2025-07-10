package com.tpdb.domain.tpdbrestbackend.consumers.mappers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.scraper.PageLink;
import org.springframework.stereotype.Component;

@Component
public class PageLinkDtoMapper {

    public PageLinkDto toDto(PageLink i) {
        return PageLinkDto.builder()
                .lastParse(i.getLastParse())
                .link(i.getLink())
                .source(i.getSource())
                .type(i.getType())
                .sourceID(i.getSourceID())
                .build();
    }
}
