package com.tpdb.domain.internal.comunication.dto;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import lombok.Builder;

import java.io.Serializable;
@Builder
public record PageLinkRequestDto(
        LinkType type,
        int batchSize
) implements Serializable {
}
