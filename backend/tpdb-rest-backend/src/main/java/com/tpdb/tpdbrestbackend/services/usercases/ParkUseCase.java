package com.tpdb.tpdbrestbackend.services.usercases;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ParkUseCase {

    Park create(Park request);
    Optional<Park> findById(UUID id);
    Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId);
    Page<Park> findAll(Pageable pageable);
    Park update(UUID id, Park updatedPark);
    void delete(UUID id);

}
