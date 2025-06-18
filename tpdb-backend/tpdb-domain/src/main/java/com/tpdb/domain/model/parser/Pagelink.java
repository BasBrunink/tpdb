package com.tpdb.domain.model.parser;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Pagelink {

    private LocalDate lastParse;
    private String link;
    private Source source;
    private LinkType type;
    private String sourceId;
}
