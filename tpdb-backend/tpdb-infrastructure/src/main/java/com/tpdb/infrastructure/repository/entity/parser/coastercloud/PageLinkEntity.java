package com.tpdb.infrastructure.repository.entity.parser.coastercloud;

import com.tpdb.domain.model.parser.LinkType;
import com.tpdb.domain.model.parser.Source;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "parser-cc-pagelinks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PageLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate lastParse;
    private String link;
    @Enumerated(value = EnumType.STRING)
    private Source source;
    @Enumerated(value = EnumType.STRING)
    private LinkType type;
    private String sourceId;
}
