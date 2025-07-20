package com.tpdb.tpdbscraper.publishers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.comunication.dto.PageLinkRequestDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.tpdbscraper.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PageLinkPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendPagelink(PageLinkDto pageLink) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PAGELINK_ROUTING_KEY,
                pageLink
        );
    }

    public void requestPageLinks(LinkType type, int batchSize) {
        PageLinkRequestDto request  = PageLinkRequestDto.builder()
                .type(type)
                .batchSize(batchSize)
                .build();
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PAGELINK_REQUEST_ROUTING_KEY,
                request
        );
    }

    public void updatePageLink(PageLinkDto link) {
        PageLinkDto updatedPageLink = PageLinkDto.builder()
                .lastParse(LocalDateTime.now())
                .link(link.link())
                .source(link.source())
                .type(link.type())
                .sourceID(link.sourceID())
                .build();
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PAGELINK_UPDATE_ROUTINGKEY,
                updatedPageLink
        );

    }

    public void deletePageLink(String url) {

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.PAGELINK_DELETE_ROUTINGKEY,
                PageLink.builder().link(url).build()
                );
    }
}
