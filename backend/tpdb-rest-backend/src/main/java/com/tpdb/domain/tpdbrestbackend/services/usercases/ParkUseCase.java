package com.tpdb.domain.tpdbrestbackend.services.usercases;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkUseCase {

    Park create(Park request);
    Optional<Park> findById(UUID id);
    Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId);
    List<Park> findAll();
    Park update(UUID id, Park updatedPark);
    void delete(UUID id);

}
