package com.tpdb.interfaceadapter.controller;

import com.tpdb.application.port.in.CreateParkUseCase;
import com.tpdb.application.port.in.ListParksUseCase;
import com.tpdb.domain.model.Park;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parks")
public class ParkController {
    private final CreateParkUseCase createParkUseCase;
    private final ListParksUseCase listParksUseCase;

    @PostMapping()
    public ResponseEntity<Void> createPark(@RequestBody ParkDto dto) {
        createParkUseCase.create(dto.name(), dto.location());
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Park>> getAllParks() {
        return ResponseEntity.ok(listParksUseCase.list());
    }

    public record ParkDto(String name, String location) {}
}
