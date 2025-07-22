package com.tpdb.tpdbrestbackend.consumers;


import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.comunication.dto.PageLinkRequestDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.tpdbrestbackend.config.RabbitConfig;
import com.tpdb.tpdbrestbackend.consumers.mappers.PageLinkDtoMapper;
import com.tpdb.tpdbrestbackend.services.usecases.internal.PageLinkUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PageLinkConsumer {

    private final PageLinkUseCase pagelinkService;
    private final PageLinkDtoMapper pageLinkDtoMapper;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitConfig.PAGELINK_QUEUE_NAME)
    public void handleMessage(PageLinkDto request) {
        log.info("Recieved PageLink: {}", request.link());
        PageLink pageLink = PageLink.builder()
                .lastParse(request.lastParse())
                .link(request.link())
                .source(request.source())
                .type(request.type())
                .sourceID(request.sourceID())
                .build();
        pagelinkService.create(pageLink);

    }

    @RabbitListener(queues = RabbitConfig.PAGELINK_REQUEST_QUEUE_NAME)
    public void handlePageLinkRequest(PageLinkRequestDto request) {
        List<PageLinkDto> batch = pagelinkService.findNextBatchToParse(request.type(), request.batchSize()).stream().map(pageLinkDtoMapper::toDto).toList();

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PAGELINK_FETCH_ROUTING_KEY,
                batch
        );
    }

    @RabbitListener(queues = RabbitConfig.PAGELINK_UPDATE_QUEUE_NAME)
    public void handleUpdateLastParse(PageLinkDto dto) {

        Optional<PageLink> foundLink = pagelinkService.findByLink(dto.link());
        if (foundLink.isPresent()) {
            PageLink fl = foundLink.get();
            fl.setLastParse(dto.lastParse());
            pagelinkService.update(fl.getId(), fl);
        }
    }

    @RabbitListener(queues = RabbitConfig.PAGELINK_DELETE_QUEUE_NAME)

    public void handleDelete(PageLinkDto dto) {
        Optional<PageLink> foundLink = pagelinkService.findByLink(dto.link());
        foundLink.ifPresent(pageLink -> pagelinkService.delete(pageLink.getId()));
    }
}
