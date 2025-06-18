package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.RestaurantTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaRestaurantTypeRepository extends JpaRepository<RestaurantTypeEntity, UUID> {
    Optional<RestaurantTypeEntity> findByType(String type);
}
