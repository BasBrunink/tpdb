package com.tpdb.domain.tpdbrestbackend.persistence.repositories.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkRepository {
    Park save(Park park);
    Optional<Park> findyById(UUID id);
    Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId);
    List<Park> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);

}
