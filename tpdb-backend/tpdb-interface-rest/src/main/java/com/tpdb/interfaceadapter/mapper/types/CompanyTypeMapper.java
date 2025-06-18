package com.tpdb.interfaceadapter.mapper.types;

import com.tpdb.domain.model.types.CompanyType;
import com.tpdb.interfaceadapter.dto.types.companytype.CompanyTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyTypeMapper {

    public CompanyTypeResponse toResponse(CompanyType input) {
        return CompanyTypeResponse.builder()
                .id(input.getId())
                .type(input.getType())
                .description(input.getDescription())
                .build();
    }
}
