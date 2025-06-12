package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.ParkTypeUseCase;
import com.tpdb.interfaceadapter.dto.parktype.ParkTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.ParkTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/park-types")
public class ParkTypeController {

    private final ParkTypeUseCase parkTypeUseCase;
    private final ParkTypeMapper parkTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<ParkTypeResponse> getParkTypeById(@PathVariable(name = "id") UUID id) {
        return parkTypeUseCase.findById(id)
                .map(parkTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<ParkTypeResponse> getParkTypeByType(@PathVariable(name = "type") String type) {
        return parkTypeUseCase.findByType(type)
                .map(parkTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<ParkTypeResponse>> getAll() {
        return ResponseEntity.ok(parkTypeUseCase.findAll().stream()
                .map(parkTypeMapper::toResponse).toList());
    }

}
