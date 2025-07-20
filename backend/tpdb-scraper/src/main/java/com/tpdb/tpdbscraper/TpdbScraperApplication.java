package com.tpdb.tpdbscraper;

import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.tpdbscraper.config.RabbitConfig;
import com.tpdb.tpdbscraper.publishers.PageLinkPublisher;
import com.tpdb.tpdbscraper.scraper.coastercloud.pagelink.PageLinkScraper;
import com.tpdb.tpdbscraper.scraper.coastercloud.park.ParkScraper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TpdbScraperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TpdbScraperApplication.class, args);
    }

    private final PageLinkScraper pageLinkScraper;
    private final ParkScraper parkScraper;
    private final RabbitAdmin rabbitAdmin;
    private final PageLinkPublisher pageLinkPublisher;
    @Override
    public void run(String... args) throws Exception {

        rabbitAdmin.purgeQueue(RabbitConfig.PAGELINK_FETCH_QUEUE_NAME, false);
//       pageLinkScraper.scrapeParkLinks();
//        pageLinkScraper.scrapeAttractionLinks();
        pageLinkPublisher.requestPageLinks(LinkType.PARK, 10);

    }
}
