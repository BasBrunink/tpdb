package com.tpdb.domain.tpdbrestbackend.persistence.jpa;

import com.tpdb.domain.tpdbrestbackend.persistence.entities.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JpaParkRepository extends JpaRepository<ParkEntity, UUID> {
}
