package com.tpdb.infrastructure.repository.jpa;

import com.tpdb.infrastructure.repository.entity.ParkEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JpaParkRepository extends JpaRepository<ParkEntity, UUID> {
}
