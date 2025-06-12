package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.RideType;
import com.tpdb.domain.port.types.RideTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaRideTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.RideTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RideTypeAdapter  implements RideTypeRepository {

    private final JpaRideTypeRepository rideTypeRepository;
    private final RideTypeEntityMapper rideTypeMapper;

    @Override
    public Optional<RideType> findById(UUID id) {
        return rideTypeRepository.findById(id)
                .map(rideTypeMapper::toDomain);
    }

    @Override
    public Optional<RideType> findByType(String type) {
        return rideTypeRepository.findByType(type)
                .map(rideTypeMapper::toDomain);
    }

    @Override
    public List<RideType> findAll() {
        return rideTypeRepository.findAll().stream()
                .map(rideTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
