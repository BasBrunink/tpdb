package com.tpdb.tpdbrestbackend.persistence.adapter.sql.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.jpa.data.JpaParkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.data.ParkEntityMapper;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.ParkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class JpaParkRepositoryAdapter implements ParkRepository {

    private final JpaParkRepository parkRepository;
    private final ParkEntityMapper parkEntityMapper;

    @Override
    public Park save(Park park) {
        return parkEntityMapper.toDomain(
                parkRepository.save(
                        parkEntityMapper.toEntity(park)
        ));
    }

    @Override
    public Optional<Park> findyById(UUID id) {

        return parkRepository.findById(id).map(parkEntityMapper::toDomain);
    }

    @Override
    public Optional<Park> findBySourceAndSourceId(ScrapeSource source, String sourceId) {
        return parkRepository.findBySourceAndSourceId(source, sourceId).map(parkEntityMapper::toDomain);
    }

    @Override
    public Page<Park> findAll(Pageable pageable) {
        return parkRepository.findAll(pageable).map(parkEntityMapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        parkRepository.deleteById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return parkRepository.existsById(id);
    }
}
