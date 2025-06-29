package com.tpdb.domain.tpdbrestbackend.persistence.repositories;

import com.tpdb.domain.Park;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkRepository {
    Park save(Park park);
    Optional<Park> findyById(UUID id);
    List<Park> findAll();
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
