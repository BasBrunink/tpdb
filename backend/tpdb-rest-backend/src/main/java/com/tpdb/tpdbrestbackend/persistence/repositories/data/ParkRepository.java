package com.tpdb.tpdbrestbackend.persistence.repositories.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ParkRepository {
    Park save(Park park);
    Optional<Park> findyById(UUID id);
    Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId);
    Page<Park> findAll(Pageable pageable);
    void deleteById(UUID id);
    boolean existsById(UUID id);

}
