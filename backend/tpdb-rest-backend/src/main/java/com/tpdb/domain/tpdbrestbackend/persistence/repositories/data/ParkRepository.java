package com.tpdb.domain.tpdbrestbackend.persistence.repositories.data;

import com.tpdb.domain.data.Park;

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
