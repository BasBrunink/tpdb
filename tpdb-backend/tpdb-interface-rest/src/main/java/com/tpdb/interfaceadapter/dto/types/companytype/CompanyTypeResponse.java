package com.tpdb.interfaceadapter.dto.types.companytype;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CompanyTypeResponse(
        UUID id,
        String type,
        String description
) {
}
