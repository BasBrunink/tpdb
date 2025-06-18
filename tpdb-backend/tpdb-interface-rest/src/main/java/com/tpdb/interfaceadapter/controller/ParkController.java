package com.tpdb.interfaceadapter.controller;

import com.tpdb.application.port.in.data.ParkUseCase;
import com.tpdb.domain.model.Park;
import com.tpdb.interfaceadapter.dto.park.CreateParkRequest;
import com.tpdb.interfaceadapter.dto.park.ParkResponse;
import com.tpdb.interfaceadapter.mapper.ParkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parks")
public class ParkController {
    private final ParkUseCase parkUseCase;
    private final ParkMapper parkMapper;

    @PostMapping()
    public ResponseEntity<ParkResponse> createPark(@RequestBody CreateParkRequest request) {
        ParkResponse response =  parkMapper.toResponse(parkUseCase.create(request.name(), request.parkTypeId()
                ,request.locationId()));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<List<Park>> getAllParks() {
        return ResponseEntity.ok(parkUseCase.list());
    }

}
