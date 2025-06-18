package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.ShopTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.shoptype.ShopTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.ShopTypeMapper;
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
@RequestMapping("/Shop-types")
public class ShopTypeController {


    private final ShopTypeUseCase shopTypeUseCase;
    private final ShopTypeMapper shopTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<ShopTypeResponse> getShopTypeById(
            @PathVariable(name = "id") UUID id) {
        return shopTypeUseCase.findById(id)
                .map(shopTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<ShopTypeResponse> getShopTypeByType(
            @PathVariable(name = "type") String type) {
        return shopTypeUseCase.findByType(type)
                .map(shopTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ShopTypeResponse>> getAll() {
        return ResponseEntity.ok(shopTypeUseCase.findAll().stream()
                .map(shopTypeMapper::toResponse).toList());
    }


}
