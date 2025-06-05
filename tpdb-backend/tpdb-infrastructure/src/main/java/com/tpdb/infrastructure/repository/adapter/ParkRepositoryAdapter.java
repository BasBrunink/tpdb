package com.tpdb.infrastructure.repository.adapter;

import com.tpdb.infrastructure.repository.entity.ParkEntity;
import com.tpdb.infrastructure.repository.jpa.JpaParkRepository;
import com.tpdb.domain.model.Park;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.infrastructure.repository.mapper.ParkInfraStructureMapper;
import com.tpdb.infrastructure.repository.mapper.types.ParkTypeInfraStrucureMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParkRepositoryAdapter implements ParkRepository {
    private final JpaParkRepository parkRepository;
    private final ParkInfraStructureMapper parkInfraStructureMapper;
    private final ParkTypeInfraStrucureMapper parkTypeInfraStrucureMapper;

    @Override
    public Park save(Park park) {
        return parkInfraStructureMapper.toDomain(parkRepository.save(
                ParkEntity.builder()
                        .id(park.getId())
                        .name(park.getName())
                        .location(park.getLocation())
                        .parkType(parkTypeInfraStrucureMapper.toEntity(park.getParkType()))
                        .build()));
    }

    @Override
    public Optional<Park> findById(UUID id) {
        return parkRepository.findById(id).map(parkInfraStructureMapper::toDomain);

    }

    @Override
    public List<Park> findAll() {
        return parkRepository.findAll().stream().map(parkInfraStructureMapper::toDomain)
                .collect(Collectors.toList());
    }

}
