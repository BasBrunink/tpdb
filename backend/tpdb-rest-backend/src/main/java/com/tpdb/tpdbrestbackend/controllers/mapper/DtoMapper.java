package com.tpdb.tpdbrestbackend.controllers.mapper;

public interface DtoMapper<D,R,S>{

    D toDomain(R req);
    S toResponse(D domain);

}
