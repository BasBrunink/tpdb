package com.tpdb.domain.port.parser.coastercloud;

import com.tpdb.domain.model.parser.Pagelink;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PageLinkRepository {

    Pagelink save(Pagelink pagelink);
    Optional<Pagelink> findById(UUID id);
    List<Pagelink> findAll();
}
