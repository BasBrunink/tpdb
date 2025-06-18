package com.tpdb.interfaceadapter.controller.types;

import com.tpdb.application.port.in.data.types.CompanyTypeUseCase;
import com.tpdb.interfaceadapter.dto.types.companytype.CompanyTypeResponse;
import com.tpdb.interfaceadapter.dto.types.parktype.ParkTypeResponse;
import com.tpdb.interfaceadapter.mapper.types.CompanyTypeMapper;
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
@RequestMapping("/company-types")
public class CompanyTypeController {

    private final CompanyTypeUseCase companyTypeUseCase;
    private final CompanyTypeMapper companyTypeMapper;

    @GetMapping("/by-id/{id}")
    public ResponseEntity<CompanyTypeResponse> getCompanyTypeById(
            @PathVariable(name = "id") UUID id) {
        return companyTypeUseCase.findById(id)
                .map(companyTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<CompanyTypeResponse> getCompanyTypeByType(
            @PathVariable(name = "type") String type) {
        return companyTypeUseCase.findByType(type)
                .map(companyTypeMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<CompanyTypeResponse>> getAll() {
        return ResponseEntity.ok(companyTypeUseCase.findAll().stream()
                .map(companyTypeMapper::toResponse).toList());
    }
}
