package com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql;

import com.tpdb.domain.Park;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.JpaParkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.mapper.ParkEntityMapper;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.ParkRepository;
import lombok.NoArgsConstructor;
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
