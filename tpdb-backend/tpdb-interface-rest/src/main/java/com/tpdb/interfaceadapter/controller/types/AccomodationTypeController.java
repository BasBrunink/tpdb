package com.tpdb.interfaceadapter.controller.types;


import com.tpdb.application.port.in.data.types.AccommodationTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.accommodationtype.AccommodationTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.AccommodationTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accommodation-types")
public class AccomodationTypeController {

    private final AccommodationTypeUseCase accommodationTypeUseCase;
    private final AccommodationTypeMapper accommodationTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<AccommodationTypeResponse> getPArkById(
            @PathVariable(name = "id")UUID id) {
        return accommodationTypeUseCase.findById(id)
                .map(accommodationTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
