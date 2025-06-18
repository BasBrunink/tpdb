package com.tpdb.interfaceadapter.controller.types;


import com.tpdb.application.port.in.data.types.StatusTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.statustype.StatusTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.StatusTypeMapper;
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
@RequestMapping("/status-types")
public class StatusTypeController {

    private final StatusTypeUseCase statusTypeUseCase;
    private final StatusTypeMapper statusTypeMapper;


    @GetMapping("/by-id/{id}")
    public ResponseEntity<StatusTypeResponse> getStatusTypeById(
            @PathVariable(name = "id") UUID id) {
        return statusTypeUseCase.findById(id)
                .map(statusTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<StatusTypeResponse> getStatusTypeByType(
            @PathVariable(name = "type") String type) {
        return statusTypeUseCase.findByType(type)
                .map(statusTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<StatusTypeResponse>> getAll() {
        return ResponseEntity.ok(statusTypeUseCase.findAll().stream()
                .map(statusTypeMapper::toResponse).toList());
    }

}
