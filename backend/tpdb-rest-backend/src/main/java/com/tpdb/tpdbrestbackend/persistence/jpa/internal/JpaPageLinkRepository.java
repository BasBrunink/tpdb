package com.tpdb.tpdbrestbackend.persistence.jpa.internal;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaPageLinkRepository extends JpaRepository<PageLinkEntity, UUID> {

    @Query("""
    SELECT p FROM PageLinkEntity p
    WHERE p.type = :type
      AND (p.lastParse IS NULL OR p.lastParse < :cutoff)
    ORDER BY p.lastParse ASC
""")
    List<PageLinkEntity> findNextBatch(@Param("type") LinkType type, @Param("cutoff") LocalDateTime cutoff, Pageable pageable);

    Optional<PageLinkEntity> findByLink(String link);
}
