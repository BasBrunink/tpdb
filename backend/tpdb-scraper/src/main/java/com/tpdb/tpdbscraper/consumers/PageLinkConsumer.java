package com.tpdb.tpdbscraper.consumers;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.tpdbscraper.config.RabbitConfig;
import com.tpdb.tpdbscraper.publishers.PageLinkPublisher;
import com.tpdb.tpdbscraper.publishers.ParkPublisher;
import com.tpdb.tpdbscraper.scraper.coastercloud.park.ParkScraper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PageLinkConsumer {

    private final ParkScraper parkScraper;
    private final ParkPublisher parkPublisher;
    private final PageLinkPublisher pageLinkPublisher;


    @RabbitListener(queues = RabbitConfig.PAGELINK_FETCH_QUEUE_NAME)
    public void handleFetchedLinks(List<PageLinkDto> links) {
        log.info(String.valueOf(links.size()));
        links.forEach(link -> {
            try {
                ParkDto dto = parkScraper.scrapePark(PageLink.builder()
                        .link(link.link())
                        .lastParse(link.lastParse())
                        .source(link.source())
                        .type(link.type())
                        .sourceID(link.sourceID())
                        .build());

                if(dto != null) {
                    parkPublisher.sendPark(dto);
                    pageLinkPublisher.updatePageLink(link);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
