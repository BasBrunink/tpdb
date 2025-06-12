package com.tpdb.infrastructure.repository.entity.types;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "company_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CompanyTypeEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String type;
    @Column(columnDefinition = "text")
    private String description;
}
