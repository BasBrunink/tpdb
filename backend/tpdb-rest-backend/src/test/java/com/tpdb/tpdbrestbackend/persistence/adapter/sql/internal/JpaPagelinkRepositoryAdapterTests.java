package com.tpdb.tpdbrestbackend.persistence.adapter.sql.internal;


import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.tpdbrestbackend.persistence.entities.internal.PageLinkEntity;
import com.tpdb.tpdbrestbackend.persistence.jpa.internal.JpaPageLinkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.internal.PageLinkEntityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import java.util.UUID;

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
}