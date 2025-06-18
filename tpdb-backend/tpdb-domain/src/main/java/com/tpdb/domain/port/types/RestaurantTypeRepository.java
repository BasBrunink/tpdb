package com.tpdb.domain.port.types;

import com.tpdb.domain.model.types.RestaurantType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantTypeRepository {
    Optional<RestaurantType> findById(UUID id);
    Optional<RestaurantType> findByType(String type);
    List<RestaurantType> findAll();
}
