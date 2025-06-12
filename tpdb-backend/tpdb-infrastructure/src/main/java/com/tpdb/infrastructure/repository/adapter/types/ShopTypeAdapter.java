package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.ShopType;
import com.tpdb.domain.port.types.ShopTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaShopTypeRepository;

import com.tpdb.infrastructure.repository.mapper.types.ShopTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ShopTypeAdapter implements ShopTypeRepository {

    private final JpaShopTypeRepository shopTypeRepository;
    private final ShopTypeEntityMapper shopTypeMapper;

    @Override
    public Optional<ShopType> findById(UUID id) {
        return shopTypeRepository.findById(id)
                .map(shopTypeMapper::toDomain);
    }

    @Override
    public Optional<ShopType> findByType(String type) {
        return shopTypeRepository.findByType(type)
                .map(shopTypeMapper::toDomain);
    }

    @Override
    public List<ShopType> findAll() {
        return shopTypeRepository.findAll().stream()
                .map(shopTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
