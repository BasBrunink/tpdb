package com.tpdb.application.service;

import com.tpdb.application.port.in.CreateParkUseCase;
import com.tpdb.application.port.in.ListParksUseCase;
import com.tpdb.domain.model.Park;
import com.tpdb.domain.port.ParkRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ParkService implements CreateParkUseCase, ListParksUseCase {

    private final ParkRepository parkRepository;

    @Override
    public void create(String name, String location) {
        Park park = new Park(UUID.randomUUID(), name, location);
        parkRepository.save(park);
    }

    @Override
    public List<Park> list() {
        return parkRepository.findAll();
    }
}
