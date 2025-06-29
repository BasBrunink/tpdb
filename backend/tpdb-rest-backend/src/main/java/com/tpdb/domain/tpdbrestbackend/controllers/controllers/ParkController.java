package com.tpdb.domain.tpdbrestbackend.controllers.controllers;

import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.ParkResponse;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.newPark.CreateNewParkRequest;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.newPark.CreateParkResponse;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkRequest;
import com.tpdb.domain.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkResponse;
import com.tpdb.domain.tpdbrestbackend.controllers.mapper.DtoMapper;
import com.tpdb.domain.tpdbrestbackend.controllers.mapper.NewParkMapper;
import com.tpdb.domain.tpdbrestbackend.controllers.mapper.ParkMapper;
import com.tpdb.domain.tpdbrestbackend.controllers.mapper.UpdateParkMapper;
import com.tpdb.domain.tpdbrestbackend.services.usercases.ParkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("parks")
@RequiredArgsConstructor
public class ParkController {

    private final ParkUseCase parkUseCase;
    private final NewParkMapper newParkMapper;
    private final UpdateParkMapper updateParkMapper;
    private final ParkMapper parkMapper;

    @PostMapping()
    public ResponseEntity<CreateParkResponse> createPark(@RequestBody CreateNewParkRequest request) {
        CreateParkResponse response = newParkMapper.toResponse(parkUseCase.create(newParkMapper.toDomain(request)));
        return ResponseEntity.ok(response);
    }

    @GetMapping()
    public ResponseEntity<List<ParkResponse>> getAllParks() {
        return ResponseEntity.ok(parkUseCase.findAll().stream().map(parkMapper::toResponse).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ParkResponse> getParkById(@PathVariable(name = "id")String id) {
        return parkUseCase.findById(UUID.fromString(id))
                .map(parkMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<UpdateParkResponse> updatePark(
            @PathVariable(name = "id") String id,
            @RequestBody UpdateParkRequest request) {
        return ResponseEntity.ok(
                updateParkMapper.toResponse(
                        parkUseCase.update(
                                UUID.fromString(id),
                                updateParkMapper.toDomain(request)
                        )
                )
        );

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePark(@PathVariable(name = "id") String id) {
        parkUseCase.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }


}
