package com.tpdb.domain.tpdbrestbackend.consumers;


import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.tpdbrestbackend.config.RabbitConfig;
import com.tpdb.domain.tpdbrestbackend.services.usercases.internal.PageLinkUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PageLinkConsumer {

    private final PageLinkUseCase pagelinkService;

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


}
