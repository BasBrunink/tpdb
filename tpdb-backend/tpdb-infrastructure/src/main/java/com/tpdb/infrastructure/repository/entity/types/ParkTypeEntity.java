package com.tpdb.infrastructure.repository.entity.types;

import com.tpdb.infrastructure.repository.entity.ParkEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "park_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParkTypeEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String type;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "parkType",fetch = FetchType.LAZY)
    private List<ParkEntity> parks;
}
