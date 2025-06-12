package com.tpdb.infrastructure.repository.adapter.types;

import com.tpdb.domain.model.types.RestaurantType;
import com.tpdb.domain.port.types.RestaurantTypeRepository;
import com.tpdb.infrastructure.repository.jpa.types.JpaRestaurantTypeRepository;
import com.tpdb.infrastructure.repository.mapper.types.RestaurantTypeEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class RestaurantTypeRepositoryAdapter implements RestaurantTypeRepository {

    private final JpaRestaurantTypeRepository restaurantTypeRepository;
    private final RestaurantTypeEntityMapper restaurantTypeMapper;

    @Override
    public Optional<RestaurantType> findById(UUID id) {
        return restaurantTypeRepository.findById(id).map(restaurantTypeMapper::toDomain);
    }

    @Override
    public Optional<RestaurantType> findByType(String type) {
        return restaurantTypeRepository.findByType(type).map(restaurantTypeMapper::toDomain);
    }

    @Override
    public List<RestaurantType> findAll() {
        return restaurantTypeRepository.findAll().stream()
                .map(restaurantTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
