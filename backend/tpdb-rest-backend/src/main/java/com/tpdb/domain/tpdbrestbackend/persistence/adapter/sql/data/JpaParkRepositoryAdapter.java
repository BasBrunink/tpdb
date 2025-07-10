package com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql.data;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.data.JpaParkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.data.ParkEntityMapper;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.data.ParkRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
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
    public List<Park> findAll() {

        return parkRepository.findAll().stream().map(parkEntityMapper::toDomain).toList();
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
