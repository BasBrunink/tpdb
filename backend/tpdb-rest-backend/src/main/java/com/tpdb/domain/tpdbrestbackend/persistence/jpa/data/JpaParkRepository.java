package com.tpdb.domain.tpdbrestbackend.persistence.jpa.data;

import com.tpdb.domain.tpdbrestbackend.persistence.entities.data.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JpaParkRepository extends JpaRepository<ParkEntity, UUID> {
}
