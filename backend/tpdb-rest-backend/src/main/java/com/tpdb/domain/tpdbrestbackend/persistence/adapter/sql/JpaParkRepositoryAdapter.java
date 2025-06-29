package com.tpdb.domain.tpdbrestbackend.persistence.adapter.sql;

import com.tpdb.domain.Park;
import com.tpdb.domain.tpdbrestbackend.persistence.jpa.JpaParkRepository;
import com.tpdb.domain.tpdbrestbackend.persistence.repositories.ParkRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class JpaParkRepositoryAdapter implements ParkRepository {

    private final JpaParkRepository parkRepository;

    @Override
    public Park save(Park park) {
        return
    }

    @Override
    public Optional<Park> findyById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Park> findall() {
        return List.of();
    }
}
