package com.tpdb.tpdbrestbackend.persistence.adapter.sql.internal;


import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import com.tpdb.tpdbrestbackend.persistence.jpa.internal.JpaPageLinkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.internal.PageLinkEntityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@DisplayName("JpaPagelinkRepositoryAdapter")
class JpaPageLinkRepositoryAdapterTests {

    private final JpaPageLinkRepository pagelinkRepository = mock(JpaPageLinkRepository.class);
    private final PageLinkEntityMapper pageLinkEntityMapper = mock(PageLinkEntityMapper.class);
    private final JpaPagelinkRepositoryAdapter adapter = new JpaPagelinkRepositoryAdapter(pagelinkRepository, pageLinkEntityMapper);

    @Test
    void savesPageLinkAndReturnsMappedDomain() {
        PageLink pageLink = PageLink.builder().build();
        PageLinkEntity entity = PageLinkEntity.builder().build();

        when(pageLinkEntityMapper.toEntity(pageLink)).thenReturn(entity);
        when(pagelinkRepository.save(entity)).thenReturn(entity);
        when(pageLinkEntityMapper.toDomain(entity)).thenReturn(pageLink);

        PageLink result = adapter.save(pageLink);

        assertThat(result).isEqualTo(pageLink);
        verify(pagelinkRepository).save(entity);
    }

    @Test
    void FindAllreturnsListMappedDomain() {
        List<PageLinkEntity> pageLinksEntities= new ArrayList<>();
        PageLinkEntity entity = PageLinkEntity.builder().link("").build();
        PageLink pageLink  = PageLink.builder().link("").build();
        pageLinksEntities.add(entity);

        when(pagelinkRepository.findAll()).thenReturn(pageLinksEntities);
        when(pageLinkEntityMapper.toDomain(entity)).thenReturn(pageLink);
        List<PageLink> result = adapter.findAll();
        assertThat(result).contains( pageLink);
    }

    @Test
    void findsPageLinkByIdAndReturnsMappedDomain() {
        UUID id = UUID.randomUUID();
        PageLinkEntity entity = PageLinkEntity.builder().build();
        PageLink pageLink = PageLink.builder().build();

        when(pagelinkRepository.findById(id)).thenReturn(Optional.of(entity));
        when(pageLinkEntityMapper.toDomain(entity)).thenReturn(pageLink);

        Optional<PageLink> result = adapter.findById(id);

        assertThat(result).contains(pageLink);
    }

    @Test
    void findsPageLinkByIdReturnsEmptyWhenNotFound() {
        UUID id = UUID.randomUUID();

        when(pagelinkRepository.findById(id)).thenReturn(Optional.empty());

        Optional<PageLink> result = adapter.findById(id);

        assertThat(result).isEmpty();
    }

    @Test
    void findsPageLinkByLinkAndReturnsMappedDomain() {
        String link = "id";
        PageLinkEntity entity = PageLinkEntity.builder().build();
        PageLink pageLink = PageLink.builder().build();
        when(pagelinkRepository.findByLink(link)).thenReturn(Optional.of(entity));
        when(pageLinkEntityMapper.toDomain(entity)).thenReturn(pageLink);

        Optional<PageLink> result = adapter.findByLink(link);

        assertThat(result).contains(pageLink);
    }

    @Test
    void findsPageLinkByLinkReturnsEmptyWhenNotFound() {
        String link = "";

        when(pagelinkRepository.findByLink(link)).thenReturn(Optional.empty());

        Optional<PageLink> result = adapter.findByLink(link);

        assertThat(result).isEmpty();
    }

    @Test
    void deletesPageLinkById() {
        UUID id = UUID.randomUUID();

        adapter.deleteById(id);

        verify(pagelinkRepository).deleteById(id);
    }

    @Test
    void checksIfPageLinkExistsByIdReturnsTrue() {
        UUID id = UUID.randomUUID();

        when(pagelinkRepository.existsById(id)).thenReturn(true);

        boolean exists = adapter.existsById(id);

        assertThat(exists).isTrue();
    }

    @Test
    void checksIfPageLinkExistsByIdReturnsFalse() {
        UUID id = UUID.randomUUID();

        when(pagelinkRepository.existsById(id)).thenReturn(false);

        boolean exists = adapter.existsById(id);

        assertThat(exists).isFalse();
    }

    @Test
    void returnsMappedDomainListWhenEntitiesFoundForTypeAndCutoff() {
        LinkType type = LinkType.PARK;
        LocalDateTime cutoff = LocalDateTime.of(2025, 1, 1, 12, 0);
        int batchSize = 2;
        PageLinkEntity entity1 = PageLinkEntity.builder().build();
        PageLinkEntity entity2 = PageLinkEntity.builder().build();
        PageLink pageLink1 = PageLink.builder().build();
        PageLink pageLink2 = PageLink.builder().build();

        when(pagelinkRepository.findNextBatch(type, cutoff, PageRequest.of(0, batchSize)))
                .thenReturn(List.of(entity1, entity2));
        when(pageLinkEntityMapper.toDomain(entity1)).thenReturn(pageLink1);
        when(pageLinkEntityMapper.toDomain(entity2)).thenReturn(pageLink2);

        List<PageLink> result = adapter.findTopNByTypeAndParseDue(type, cutoff, batchSize);

        assertThat(result).containsExactly(pageLink1, pageLink2);
    }

    @Test
    void returnsEmptyListWhenNoEntitiesFoundForTypeAndCutoff() {
        LinkType type = LinkType.PARK;
        LocalDateTime cutoff = LocalDateTime.now();
        int batchSize = 5;

        when(pagelinkRepository.findNextBatch(type, cutoff, PageRequest.of(0, batchSize)))
                .thenReturn(emptyList());

        List<PageLink> result = adapter.findTopNByTypeAndParseDue(type, cutoff, batchSize);

        assertThat(result).isEmpty();
    }

}