package com.tpdb.tpdbrestbackend.services.implementation.internal;

import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.repositories.internal.PagelinkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class PageLinkServiceTests {
    private PagelinkRepository pagelinkRepository;
    private PageLinkService pageLinkService;

    @BeforeEach
    void setUp() {
        pagelinkRepository = mock(PagelinkRepository.class);
        pageLinkService = new PageLinkService(pagelinkRepository);
    }

    @Test
    void create_ShouldSavePageLinkWithCurrentTimestamp() {
        PageLink pageLink = new PageLink();
        pageLinkService.create(pageLink);
        verify(pagelinkRepository, times(1)).save(pageLink);
        assertNotNull(pageLink.getCreatedAt());
    }

    @Test
    void findById_ShouldReturnPageLink_WhenExists() {
        UUID id = UUID.randomUUID();
        PageLink pageLink = new PageLink();
        when(pagelinkRepository.findById(id)).thenReturn(Optional.of(pageLink));
        Optional<PageLink> result = pageLinkService.findById(id);
        assertTrue(result.isPresent());
        assertEquals(pageLink, result.get());
    }

    @Test
    void findById_ShouldReturnEmpty_WhenNotExists() {
        UUID id = UUID.randomUUID();
        when(pagelinkRepository.findById(id)).thenReturn(Optional.empty());
        Optional<PageLink> result = pageLinkService.findById(id);
        assertFalse(result.isPresent());
    }

    @Test
    void findByLink_ShouldReturnPageLink_WhenExists() {
        String link = "http://example.com";
        PageLink pageLink = new PageLink();
        when(pagelinkRepository.findByLink(link)).thenReturn(Optional.of(pageLink));
        Optional<PageLink> result = pageLinkService.findByLink(link);
        assertTrue(result.isPresent());
        assertEquals(pageLink, result.get());
    }

    @Test
    void findByLink_ShouldReturnEmpty_WhenNotExists() {
        String link = "http://notfound.com";
        when(pagelinkRepository.findByLink(link)).thenReturn(Optional.empty());
        Optional<PageLink> result = pageLinkService.findByLink(link);
        assertFalse(result.isPresent());
    }

    @Test
    void findAll_ShouldReturnAllPageLinks() {
        List<PageLink> pageLinks = Arrays.asList(new PageLink(), new PageLink());
        when(pagelinkRepository.findAll()).thenReturn(pageLinks);
        List<PageLink> result = pageLinkService.findAll();
        assertEquals(pageLinks.size(), result.size());
        assertEquals(pageLinks, result);
    }

    @Test
    void update_ShouldUpdateExistingPageLink() {
        UUID id = UUID.randomUUID();
        PageLink existing = new PageLink();
        PageLink updated = new PageLink();
        updated.setLastParse(LocalDateTime.now());
        updated.setLink("newLink");
        updated.setSource(ScrapeSource.COASTERCLOUD);
        updated.setType(LinkType.PARK);
        updated.setSourceID("newSourceID");

        when(pagelinkRepository.findById(id)).thenReturn(Optional.of(existing));
        when(pagelinkRepository.save(existing)).thenReturn(existing);

        pageLinkService.update(id, updated);

        assertEquals("newLink", existing.getLink());
        assertEquals(ScrapeSource.COASTERCLOUD, existing.getSource());
        assertEquals(LinkType.PARK, existing.getType());
        assertEquals("newSourceID", existing.getSourceID());
        assertNotNull(existing.getUpdatedAt());
        verify(pagelinkRepository).save(existing);
    }

    @Test
    void update_ShouldThrowException_WhenPageLinkNotFound() {
        UUID id = UUID.randomUUID();
        PageLink updated = new PageLink();
        when(pagelinkRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> pageLinkService.update(id, updated));
    }

    @Test
    void delete_ShouldDeletePageLink_WhenExists() {
        UUID id = UUID.randomUUID();
        when(pagelinkRepository.existsById(id)).thenReturn(true);
        pageLinkService.delete(id);
        verify(pagelinkRepository).deleteById(id);
    }

    @Test
    void delete_ShouldThrowException_WhenPageLinkNotFound() {
        UUID id = UUID.randomUUID();
        when(pagelinkRepository.existsById(id)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> pageLinkService.delete(id));
    }

    @Test
    void findNextBatchToParse_ShouldReturnBatchOfPageLinks() {
        LinkType type = LinkType.PARK;
        int batchSize = 2;
        List<PageLink> batch = Arrays.asList(new PageLink(), new PageLink());
        when(pagelinkRepository.findTopNByTypeAndParseDue(eq(type), any(LocalDateTime.class), eq(batchSize))).thenReturn(batch);
        List<PageLink> result = pageLinkService.findNextBatchToParse(type, batchSize);
        assertEquals(batchSize, result.size());
        assertEquals(batch, result);
    }
}
