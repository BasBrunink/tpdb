package com.tpdb.domain.tpdbrestbackend.services.usercases;

import com.tpdb.domain.Park;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkUseCase {

    Park create(Park request);
    Optional<Park> findById(UUID id);
    List<Park> findAll();
    Park update(UUID id, Park updatedPark);
    void delete(UUID id);
}
