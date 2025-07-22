package com.tpdb.tpdbrestbackend.consumers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.comunication.dto.PageLinkRequestDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbrestbackend.config.RabbitConfig;
import com.tpdb.tpdbrestbackend.consumers.mappers.PageLinkDtoMapper;
import com.tpdb.tpdbrestbackend.services.usecases.internal.PageLinkUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class PageLinkConsumerTests {
    private PageLinkUseCase pagelinkService;
    private PageLinkDtoMapper pageLinkDtoMapper;
    private RabbitTemplate rabbitTemplate;
    private PageLinkConsumer consumer;

    @BeforeEach
    void setup() {
        pagelinkService = mock(PageLinkUseCase.class);
        pageLinkDtoMapper = mock(PageLinkDtoMapper.class);
        rabbitTemplate = mock(RabbitTemplate.class);
        consumer = new PageLinkConsumer(pagelinkService, pageLinkDtoMapper, rabbitTemplate);
    }

    @Test
    void handleMessage_createsPageLinkFromDto() {
        PageLinkDto dto = mock(PageLinkDto.class);
        when(dto.lastParse()).thenReturn(LocalDateTime.of(2025,1,1,12,0));
        when(dto.link()).thenReturn("http://example.com");
        when(dto.source()).thenReturn(ScrapeSource.COASTERCLOUD);
        when(dto.type()).thenReturn(LinkType.PARK);
        when(dto.sourceID()).thenReturn("id");

        consumer.handleMessage(dto);

        verify(pagelinkService).create(any(PageLink.class));
    }

    @Test
    void handlePageLinkRequest_sendsBatchToRabbitTemplate() {
        PageLinkRequestDto request = mock(PageLinkRequestDto.class);
        when(request.type()).thenReturn(LinkType.PARK);
        when(request.batchSize()).thenReturn(2);

        PageLink pageLink = mock(PageLink.class);
        PageLinkDto dto = mock(PageLinkDto.class);

        when(pagelinkService.findNextBatchToParse(LinkType.PARK, 2)).thenReturn(List.of(pageLink));
        when(pageLinkDtoMapper.toDto(pageLink)).thenReturn(dto);

        consumer.handlePageLinkRequest(request);

        verify(rabbitTemplate).convertAndSend(
                eq(RabbitConfig.EXCHANGE_NAME),
                eq(RabbitConfig.PAGELINK_FETCH_ROUTING_KEY),
                eq(List.of(dto))
        );
    }

    @Test
    void handleUpdateLastParse_updatesLastParseIfFound() {
        PageLinkDto dto = mock(PageLinkDto.class);
        when(dto.link()).thenReturn("http://example.com");
        when(dto.lastParse()).thenReturn(LocalDateTime.of(2025,1,1,12,0));

        PageLink found = mock(PageLink.class);
        when(pagelinkService.findByLink("http://example.com")).thenReturn(Optional.of(found));
        when(found.getId()).thenReturn(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527"));

        consumer.handleUpdateLastParse(dto);

        verify(found).setLastParse(any());
        verify(pagelinkService).update(eq(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527")), eq(found));
    }

    @Test
    void handleUpdateLastParse_doesNothingIfNotFound() {
        PageLinkDto dto = mock(PageLinkDto.class);
        when(dto.link()).thenReturn("http://notfound.com");

        when(pagelinkService.findByLink("http://notfound.com")).thenReturn(Optional.empty());

        consumer.handleUpdateLastParse(dto);

        verify(pagelinkService, never()).update(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527"), PageLink.builder().build());
    }

    @Test
    void handleDelete_deletesPageLinkIfFound() {
        PageLinkDto dto = mock(PageLinkDto.class);
        when(dto.link()).thenReturn("http://delete.com");

        PageLink found = mock(PageLink.class);
        when(pagelinkService.findByLink("http://delete.com")).thenReturn(Optional.of(found));
        when(found.getId()).thenReturn(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527"));

        consumer.handleDelete(dto);

        verify(pagelinkService).delete(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527"));
    }

    @Test
    void handleDelete_doesNothingIfNotFound() {
        PageLinkDto dto = mock(PageLinkDto.class);
        when(dto.link()).thenReturn("http://notfound.com");

        when(pagelinkService.findByLink("http://notfound.com")).thenReturn(Optional.empty());

        consumer.handleDelete(dto);

        verify(pagelinkService, never()).delete(UUID.fromString("52097ee4-e334-4a2f-842d-a5756a220527"));
    }
}
