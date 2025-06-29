package com.tpdb.domain.tpdbrestbackend.persistence.interfaces;

public interface EntityMapper<D, E> {

    E toEntity(D domain);
    D toDomain(E entity);
}
