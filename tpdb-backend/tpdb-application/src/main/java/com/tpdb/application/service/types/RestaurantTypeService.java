package com.tpdb.application.service.types;

import com.tpdb.application.port.in.data.types.RestaurantTypeUseCase;
import com.tpdb.domain.model.types.RestaurantType;
import com.tpdb.domain.port.types.RestaurantTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class RestaurantTypeService implements RestaurantTypeUseCase {

    private final RestaurantTypeRepository restaurantTypeRepository;

    @Override
    public Optional<RestaurantType> findById(UUID id) {
        return restaurantTypeRepository.findById(id);
    }

    @Override
    public Optional<RestaurantType> findByType(String type) {
        return restaurantTypeRepository.findByType(type);
    }

    @Override
    public List<RestaurantType> findAll() {
        return restaurantTypeRepository.findAll();
    }
}
