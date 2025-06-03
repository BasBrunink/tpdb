package com.tpdb.infrastructure.repository.adapter;

import com.tpdb.infrastructure.repository.entity.ParkEntity;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.domain.model.Park;
import com.tpdb.domain.port.ParkRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParkRepositoryAdapter implements ParkRepository {
    private final JpaParkRepository jpaParkRepository;

    @Override
    public void save(Park park) {
        jpaParkRepository.save(new ParkEntity(park.getId(), park.getName(), park.getLocation()));
    }

    @Override
    public Optional<Park> findById(UUID id) {
        return jpaParkRepository.findById(id).map(this::toDomain);

    }

    @Override
    public List<Park> findAll() {
        return jpaParkRepository.findAll().stream().map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Park toDomain(ParkEntity entity) {
        return new Park(entity.getId(), entity.getName(), entity.getLocation());
    }
}
