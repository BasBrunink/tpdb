package com.tpdb.domain.tpdbrestbackend.persistence.entities.data;


import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "park",
        uniqueConstraints = @UniqueConstraint(columnNames = {"source", "source_id"})
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime created;
    private LocalDateTime updated;
//    private User updatedBy;
//    private User createdBy;

    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Enumerated(EnumType.STRING)
    private ParkType parkType;
    private LocalDate opening;
    private LocalDate closing;

    @Enumerated(EnumType.STRING)
    private ParkStatus status;
    private String address;
    private double areaSize;

    @Enumerated(EnumType.STRING)
    private ScrapeSource source;

    @Column(name="source_id")
    private String sourceId;
}
