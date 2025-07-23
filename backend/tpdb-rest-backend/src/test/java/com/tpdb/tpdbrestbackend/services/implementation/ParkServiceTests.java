package com.tpdb.tpdbrestbackend.services.implementation;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.repositories.data.ParkRepository;
import com.tpdb.tpdbrestbackend.services.implementation.data.ParkService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ParkServiceTests {
    private final ParkRepository parkRepository = mock(ParkRepository.class);
    private final ParkService service = new ParkService(parkRepository);

    @Test
    @DisplayName("create sets createdAt and updatedAt and saves park")
    void createSetsTimestampsAndSavesPark() {
        Park park = new Park();
        when(parkRepository.save(any(Park.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Park result = service.create(park);

        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());
    }

    @Test
    @DisplayName("findById returns park when found")
    void findByIdReturnsParkWhenFound() {
        UUID id = UUID.randomUUID();
        Park park = new Park();
        when(parkRepository.findyById(id)).thenReturn(Optional.of(park));

        Optional<Park> result = service.findById(id);

        assertTrue(result.isPresent());
        assertEquals(park, result.get());
    }

    @Test
    @DisplayName("findById returns empty when not found")
    void findByIdReturnsEmptyWhenNotFound() {
        UUID id = UUID.randomUUID();
        when(parkRepository.findyById(id)).thenReturn(Optional.empty());

        Optional<Park> result = service.findById(id);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("findBySourceAndSourceId returns park when found")
    void findBySourceAndSourceIdReturnsParkWhenFound() {
        ScrapeSource source = ScrapeSource.COASTERCLOUD;
        String sourceId = "source-123";
        Park park = new Park();
        when(parkRepository.findBySourceAndSourceId(source, sourceId)).thenReturn(Optional.of(park));

        Optional<Park> result = service.findBySourceAndSourceId(source, sourceId);

        assertTrue(result.isPresent());
        assertEquals(park, result.get());
    }

    @Test
    @DisplayName("findBySourceAndSourceId returns empty when not found")
    void findBySourceAndSourceIdReturnsEmptyWhenNotFound() {
        ScrapeSource source = ScrapeSource.COASTERCLOUD;
        String sourceId = "source-123";
        when(parkRepository.findBySourceAndSourceId(source, sourceId)).thenReturn(Optional.empty());

        Optional<Park> result = service.findBySourceAndSourceId(source, sourceId);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("findAll returns paged parks")
    void findAllReturnsPagedParks() {
        Pageable pageable = mock(Pageable.class);
        Park park = new Park();
        Page<Park> page = new PageImpl<>(Collections.singletonList(park));
        when(parkRepository.findAll(pageable)).thenReturn(page);

        Page<Park> result = service.findAll(pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals(park, result.getContent().getFirst());
    }

    @Test
    @DisplayName("update updates existing park fields and saves")
    void updateUpdatesExistingParkFieldsAndSaves() {
        UUID id = UUID.randomUUID();
        Park existing = new Park();
        existing.setId(id);
        Park updated = new Park();
        updated.setId(id);
        updated.setName("New Name");
        when(parkRepository.findyById(id)).thenReturn(Optional.of(existing));
        when(parkRepository.save(any(Park.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Park result = service.update(id, updated);

        assertEquals("New Name", result.getName());
        assertNotNull(result.getUpdatedAt());
    }

    @Test
    @DisplayName("update throws EntityNotFoundException when park not found")
    void updateThrowsExceptionWhenParkNotFound() {
        UUID id = UUID.randomUUID();
        Park updated = new Park();
        updated.setId(id);
        when(parkRepository.findyById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.update(id, updated));
    }

    @Test
    @DisplayName("delete removes park when exists")
    void deleteRemovesParkWhenExists() {
        UUID id = UUID.randomUUID();
        when(parkRepository.existsById(id)).thenReturn(true);

        service.delete(id);

        verify(parkRepository).deleteById(id);
    }

    @Test
    @DisplayName("delete throws EntityNotFoundException when park does not exist")
    void deleteThrowsExceptionWhenParkDoesNotExist() {
        UUID id = UUID.randomUUID();
        when(parkRepository.existsById(id)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> service.delete(id));
    }
}
