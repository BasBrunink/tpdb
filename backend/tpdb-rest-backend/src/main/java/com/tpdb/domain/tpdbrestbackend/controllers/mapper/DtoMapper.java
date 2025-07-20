package com.tpdb.domain.tpdbrestbackend.controllers.mapper;

public interface DtoMapper<D,R,S>{

    D toDomain(R req);
    S toResponse(D domain);

}
