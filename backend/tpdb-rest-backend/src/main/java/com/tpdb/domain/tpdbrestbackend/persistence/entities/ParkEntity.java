package com.tpdb.domain.tpdbrestbackend.persistence.entities;


import com.tpdb.domain.enums.ParkStatus;
import com.tpdb.domain.enums.types.ParkType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
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
}
