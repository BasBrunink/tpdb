package com.tpdb.tpdbrestbackend.persistence.adapter.sql.data;


import com.tpdb.domain.data.Park;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.persistence.entities.data.ParkEntity;
import com.tpdb.tpdbrestbackend.persistence.jpa.data.JpaParkRepository;
import com.tpdb.tpdbrestbackend.persistence.mapper.data.ParkEntityMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@DisplayName("JpaParkRepositoryAdapter")
class JpaParkRepositoryAdapterTests {

    private final JpaParkRepository parkRepository = mock(JpaParkRepository.class);
    private final ParkEntityMapper parkEntityMapper = mock(ParkEntityMapper.class);
    private final JpaParkRepositoryAdapter adapter = new JpaParkRepositoryAdapter(parkRepository, parkEntityMapper);

    @Test
    void savesParkAndReturnsMappedDomain() {
        Park park = Park.builder().build();
        ParkEntity entity = ParkEntity.builder().build();

        when(parkEntityMapper.toEntity(park)).thenReturn(entity);
        when(parkRepository.save(entity)).thenReturn(entity);
        when(parkEntityMapper.toDomain(entity)).thenReturn(park);

        Park result = adapter.save(park);

        assertThat(result).isEqualTo(park);
        verify(parkRepository).save(entity);
    }

    @Test
    void findsParkByIdAndReturnsMappedDomain() {
        UUID id = UUID.randomUUID();
        ParkEntity entity = ParkEntity.builder().build();
        Park park = Park.builder().build();

        when(parkRepository.findById(id)).thenReturn(Optional.of(entity));
        when(parkEntityMapper.toDomain(entity)).thenReturn(park);

        Optional<Park> result = adapter.findyById(id);

        assertThat(result).contains(park);
    }

    @Test
    void findsParkByIdReturnsEmptyWhenNotFound() {
        UUID id = UUID.randomUUID();

        when(parkRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Park> result = adapter.findyById(id);

        assertThat(result).isEmpty();
    }

    @Test
    void findsParkBySourceAndSourceIdReturnsMappedDomain() {
        ScrapeSource source = ScrapeSource.COASTERCLOUD;
        String sourceId = "SRCID";
        ParkEntity entity = ParkEntity.builder().build();
        Park park = Park.builder().build();

        when(parkRepository.findBySourceAndSourceId(source, sourceId)).thenReturn(Optional.of(entity));
        when(parkEntityMapper.toDomain(entity)).thenReturn(park);

        Optional<Park> result = adapter.findBySourceAndSourceId(source, sourceId);

        assertThat(result).contains(park);
    }

    @Test
    void findsParkBySourceAndSourceIdReturnsEmptyWhenNotFound() {
        ScrapeSource source = ScrapeSource.COASTERCLOUD;
        String sourceId = "SRCID";

        when(parkRepository.findBySourceAndSourceId(source, sourceId)).thenReturn(Optional.empty());

        Optional<Park> result = adapter.findBySourceAndSourceId(source, sourceId);

        assertThat(result).isEmpty();
    }

    @Test
    void findsAllParksAndMapsToDomain() {
        Pageable pageable = mock(Pageable.class);
        ParkEntity entity = ParkEntity.builder().build();
        Park park = Park.builder().build();
        Page<ParkEntity> entityPage = new PageImpl<>(Collections.singletonList(entity));

        when(parkRepository.findAll(pageable)).thenReturn(entityPage);
        when(parkEntityMapper.toDomain(entity)).thenReturn(park);

        Page<Park> result = adapter.findAll(pageable);

        assertThat(result.getContent()).containsExactly(park);
    }

    @Test
    void deletesParkById() {
        UUID id = UUID.randomUUID();

        adapter.deleteById(id);

        verify(parkRepository).deleteById(id);
    }

    @Test
    void checksIfParkExistsByIdReturnsTrue() {
        UUID id = UUID.randomUUID();

        when(parkRepository.existsById(id)).thenReturn(true);

        boolean exists = adapter.existsById(id);

        assertThat(exists).isTrue();
    }

    @Test
    void checksIfParkExistsByIdReturnsFalse() {
        UUID id = UUID.randomUUID();

        when(parkRepository.existsById(id)).thenReturn(false);

        boolean exists = adapter.existsById(id);

        assertThat(exists).isFalse();
    }
}