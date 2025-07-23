package com.tpdb.tpdbrestbackend.consumers;

import com.tpdb.domain.data.Park;
import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.services.usecases.data.ParkUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class ParkConsumerTests {


    private final LocalDate opening = LocalDate.of(2020, 1 ,1);
    private final LocalDate closing = LocalDate.of(2025, 1 ,1);
    @Mock
    private ParkUseCase parkService;

    private ParkConsumer parkConsumer;

    @BeforeEach
    void setUp() {
        openMocks(this);
        parkConsumer = new ParkConsumer(parkService);
    }

    @Test
    void handleMessage_createsPark_whenParkDoesNotExist() {
        ParkDto dto = new ParkDto("Test Park", "Desc", ParkType.AMUSEMENTPARK, opening, closing, ParkStatus.OPERATING, "Address", 100.0, "sourceA", ScrapeSource.COASTERCLOUD);
        when(parkService.findBySourceAndSourceId(ScrapeSource.COASTERCLOUD, "sourceA")).thenReturn(Optional.empty());

        parkConsumer.handleMessage(dto);

        ArgumentCaptor<Park> captor = ArgumentCaptor.forClass(Park.class);
        verify(parkService).create(captor.capture());
        Park created = captor.getValue();
        assertThat(created.getName()).isEqualTo("Test Park");
        assertThat(created.getSourceId()).isEqualTo("sourceA");
    }

    @Test
    void handleMessage_doesNotCreatePark_whenParkAlreadyExists() {
        ParkDto dto = new ParkDto("Test Park", "Desc", ParkType.AMUSEMENTPARK, opening, closing, ParkStatus.OPERATING, "Address", 100.0, "sourceA", ScrapeSource.COASTERCLOUD);
        Park existing = Park.builder().name("Test Park").sourceId("sourceA").build();
        when(parkService.findBySourceAndSourceId(ScrapeSource.COASTERCLOUD, "sourceA")).thenReturn(Optional.of(existing));

        parkConsumer.handleMessage(dto);

        verify(parkService, never()).create(any());
    }

    @Test
    void handleMessage_handlesNullFieldsGracefully() {
        ParkDto dto = new ParkDto(null, null, null, null, null, null, null, 0, "sourceA", ScrapeSource.COASTERCLOUD);
        when(parkService.findBySourceAndSourceId(ScrapeSource.COASTERCLOUD, "id123")).thenReturn(Optional.empty());

        parkConsumer.handleMessage(dto);

        verify(parkService).create(any(Park.class));
    }
}
