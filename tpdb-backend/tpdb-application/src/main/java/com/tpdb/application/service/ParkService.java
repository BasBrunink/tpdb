package com.tpdb.application.service;

import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.domain.model.Park;
import com.tpdb.domain.model.types.ParkType;
import com.tpdb.domain.port.ParkRepository;
import com.tpdb.domain.port.types.ParkTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ParkService implements ParkUseCase {

    private final ParkRepository parkRepository;
    private final ParkTypeRepository parkTypeRepository;

    @Override
    public Park create(String name, UUID parkTypeId, String location) {
        Optional<ParkType> parkType = parkTypeRepository.findById(parkTypeId);
        Park park = new Park();
        park.setId(UUID.randomUUID());
        park.setName(name);
        park.setLocation(location);
        parkType.ifPresent(park::setParkType);

        return parkRepository.save(park);
    }

    @Override
    public List<Park> list() {
        return parkRepository.findAll();
    }
}
