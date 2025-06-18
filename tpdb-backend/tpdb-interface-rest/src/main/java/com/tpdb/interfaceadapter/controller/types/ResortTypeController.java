package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.ResortTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.resorttype.ResortTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.ResortTypeMapper;
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
@RequestMapping("/resort-types")
public class ResortTypeController {

    private final ResortTypeUseCase resortTypeUseCase;
    private final ResortTypeMapper resortTypeMapper;
    @GetMapping("/by-id/{id}")
    public ResponseEntity<ResortTypeResponse> getResortTypeById(
            @PathVariable(name = "id") UUID id) {
        return resortTypeUseCase.findById(id)
                .map(resortTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<ResortTypeResponse> getResortTypeByType(
            @PathVariable(name = "type") String type) {
        return resortTypeUseCase.findByType(type)
                .map(resortTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ResortTypeResponse>> getAll() {
        return ResponseEntity.ok(resortTypeUseCase.findAll().stream()
                .map(resortTypeMapper::toResponse).toList());
    }
}
