package com.tpdb.infrastructure.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "parks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkEntity {
    @Id
    private UUID id;

    private String name;
    private String location;


}
