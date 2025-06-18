package com.tpdb.infrastructure.repository.jpa.parser.coastercloud;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tpdb.infrastructure.repository.entity.parser.coastercloud.PageLinkEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaPagelinkRepository extends JpaRepository<PageLinkEntity, UUID> {
}
