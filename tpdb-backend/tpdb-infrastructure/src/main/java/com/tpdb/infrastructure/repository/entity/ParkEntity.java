package com.tpdb.infrastructure.repository.entity;

import com.tpdb.infrastructure.repository.entity.types.ParkTypeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "parks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ParkEntity {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_type_id")
    private ParkTypeEntity parkType;
    private String name;
    private String location;


}
