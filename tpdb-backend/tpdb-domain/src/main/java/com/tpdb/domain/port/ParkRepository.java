package com.tpdb.domain.port;

import com.tpdb.domain.model.Park;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkRepository {

    void save(Park park);
    Optional<Park> findById(UUID id);
    List<Park> findAll();
}
