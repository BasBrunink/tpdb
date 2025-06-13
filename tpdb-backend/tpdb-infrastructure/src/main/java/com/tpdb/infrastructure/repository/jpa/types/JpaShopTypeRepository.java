package com.tpdb.infrastructure.repository.jpa.types;

import com.tpdb.infrastructure.repository.entity.types.ShopTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaShopTypeRepository extends JpaRepository<ShopTypeEntity, UUID> {
    Optional<ShopTypeEntity> findByType(String type);
}
