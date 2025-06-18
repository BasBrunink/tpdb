package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.ShopTypeUseCase;
import com.tpdb.domain.model.types.ShopType;
import com.tpdb.domain.port.types.ShopTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ShopTypeService implements ShopTypeUseCase {

    private final ShopTypeRepository shopTypeRepository;

    @Override
    public Optional<ShopType> findById(UUID id) {
        return shopTypeRepository.findById(id);
    }

    @Override
    public Optional<ShopType> findByType(String type) {
        return shopTypeRepository.findByType(type);
    }

    @Override
    public List<ShopType> findAll() {
        return shopTypeRepository.findAll();
    }
}
