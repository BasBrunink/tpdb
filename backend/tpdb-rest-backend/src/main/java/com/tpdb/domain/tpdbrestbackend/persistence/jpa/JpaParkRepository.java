package com.tpdb.domain.tpdbrestbackend.persistence.jpa;

import com.tpdb.domain.tpdbrestbackend.persistence.entities.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaParkRepository extends JpaRepository<ParkEntity, UUID> {
}
