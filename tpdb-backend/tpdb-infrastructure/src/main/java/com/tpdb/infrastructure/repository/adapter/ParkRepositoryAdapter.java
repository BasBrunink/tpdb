package com.tpdb.infrastructure.repository.adapter;

import com.tpdb.infrastructure.repository.entity.ParkEntity;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.domain.model.Park;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.infrastructure.repository.mapper.ParkEntityMapper;
import com.tpdb.infrastructure.repository.mapper.common.LocationEntityMapper;
import com.tpdb.infrastructure.repository.mapper.types.ParkTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParkRepositoryAdapter implements ParkRepository {
    private final JpaParkRepository parkRepository;
    private final ParkEntityMapper parkEntityMapper;
    private final ParkTypeEntityMapper parkTypeEntityMapper;
    private final LocationEntityMapper locationEntityMapper;

    @Override
    public Park save(Park park) {
        return parkEntityMapper.toDomain(parkRepository.save(
                ParkEntity.builder()
                        .id(park.getId())
                        .name(park.getName())
                        .location(locationEntityMapper.toEntity(park.getLocation()))
                        .parkType(parkTypeEntityMapper.toEntity(park.getParkType()))
                        .build()));
    }

    @Override
    public Optional<Park> findById(UUID id) {
        return parkRepository.findById(id).map(parkEntityMapper::toDomain);

    }

    @Override
    public List<Park> findAll() {
        return parkRepository.findAll().stream().map(parkEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

}
