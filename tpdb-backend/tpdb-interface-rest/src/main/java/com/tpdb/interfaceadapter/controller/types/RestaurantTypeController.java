package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.RestaurantTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.restauranttype.RestaurantTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.RestaurantTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant-types")
public class RestaurantTypeController {

    private final RestaurantTypeUseCase restaurantTypeUseCase;
    private final RestaurantTypeMapper restaurantTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<RestaurantTypeResponse> getRestaurantTypeById(
            @PathVariable(name = "id") UUID id) {
        return restaurantTypeUseCase.findById(id)
                .map(restaurantTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<RestaurantTypeResponse> getRestaurantTypeByType(
            @PathVariable(name = "type") String type) {
        return restaurantTypeUseCase.findByType(type)
                .map(restaurantTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<RestaurantTypeResponse>> getAll() {
        return ResponseEntity.ok(restaurantTypeUseCase.findAll().stream()
                .map(restaurantTypeMapper::toResponse).toList());
    }
}
