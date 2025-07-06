package com.tpdb.tpdbscraper.publishers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.tpdbscraper.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

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
}
