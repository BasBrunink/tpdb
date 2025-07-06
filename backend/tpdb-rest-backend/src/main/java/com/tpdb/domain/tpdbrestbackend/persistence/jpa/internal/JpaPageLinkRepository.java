package com.tpdb.domain.tpdbrestbackend.persistence.jpa.internal;

import com.tpdb.domain.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaPageLinkRepository extends JpaRepository<PageLinkEntity, UUID> {
}
