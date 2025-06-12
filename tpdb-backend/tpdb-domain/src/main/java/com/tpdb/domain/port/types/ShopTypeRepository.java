package com.tpdb.domain.port.types;

import com.tpdb.domain.model.types.ShopType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShopTypeRepository {
    Optional<ShopType> findById(UUID id);
    Optional<ShopType> findByType(String type);
    List<ShopType> findAll();
}
