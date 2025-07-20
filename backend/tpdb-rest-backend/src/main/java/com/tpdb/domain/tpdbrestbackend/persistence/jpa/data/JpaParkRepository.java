package com.tpdb.domain.tpdbrestbackend.persistence.jpa.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.domain.tpdbrestbackend.persistence.entities.data.ParkEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface JpaParkRepository extends JpaRepository<ParkEntity, UUID> {
    Optional<ParkEntity> findBySourceAndSourceId(ScrapeSource source, String sourceId);

    Page<ParkEntity> findAll(Pageable pageable);
}
