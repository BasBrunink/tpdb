package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.RideTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.ridetype.RideTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.RideTypeMapper;
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
@RequestMapping("/ride-types")
public class RideTypeController {

    private final RideTypeUseCase rideTypeUseCase;
    private final RideTypeMapper rideTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<RideTypeResponse> getRideTypeById(
            @PathVariable(name = "id") UUID id) {
        return rideTypeUseCase.findById(id)
                .map(rideTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<RideTypeResponse> getRideTypeByType(
            @PathVariable(name = "type") String type) {
        return rideTypeUseCase.findByType(type)
                .map(rideTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<RideTypeResponse>> getAll() {
        return ResponseEntity.ok(rideTypeUseCase.findAll().stream()
                .map(rideTypeMapper::toResponse).toList());
    }
}
