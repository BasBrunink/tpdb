package com.tpdb.tpdbrestbackend.controllers.controllers;

import com.tpdb.tpdbrestbackend.controllers.dto.park.ParkResponse;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateNewParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.newPark.CreateParkResponse;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkRequest;
import com.tpdb.tpdbrestbackend.controllers.dto.park.updatePark.UpdateParkResponse;
import com.tpdb.tpdbrestbackend.controllers.mapper.NewParkMapper;
import com.tpdb.tpdbrestbackend.controllers.mapper.ParkMapper;
import com.tpdb.tpdbrestbackend.controllers.mapper.UpdateParkMapper;
import com.tpdb.tpdbrestbackend.services.usercases.ParkUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("parks")
@RequiredArgsConstructor
@Slf4j
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
    public ResponseEntity<Page<ParkResponse>> getAllParks(Pageable pageable) {
        log.info(pageable.toString());
        return ResponseEntity.ok(parkUseCase.findAll(pageable).map(parkMapper::toResponse));
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
